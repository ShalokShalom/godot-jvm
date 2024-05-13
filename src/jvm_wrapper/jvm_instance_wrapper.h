#ifndef GODOT_JVM_JVM_INSTANCE_WRAPPER_H
#define GODOT_JVM_JVM_INSTANCE_WRAPPER_H

#include "jni/wrapper.h"
#include "lifecycle/class_loader.h"

#define JVM_INSTANCE_WRAPPER(NAME, FQNAME)                \
    inline constexpr char NAME##QualifiedName[] = FQNAME; \
    class NAME : public JvmInstanceWrapper<NAME, NAME##QualifiedName>

#define JNI_METHOD(var_name) inline static jni::MethodId var_name {nullptr};

#define INIT_JNI_METHOD(var_name, name, signature) var_name = clazz.get_method_id(p_env, name, signature);

#define INIT_NATIVE_METHOD(string_name, signature, function) \
    methods.push_back({const_cast<char*>(string_name), const_cast<char*>(signature), (void*) function});

#define INIT_JNI_BINDINGS(...)                                                       \
                                                                                     \
public:                                                                              \
    static void initialize_jni_binding(jni::Env& p_env, ClassLoader* class_loader) { \
        Vector<jni::JNativeMethod> methods;                                          \
        jni::JClass clazz;                                                           \
        if (class_loader) {                                                          \
            clazz = class_loader->load_class(p_env, get_fully_qualified_name());     \
        } else {                                                                     \
            clazz = p_env.find_class(get_fully_qualified_name());                    \
        }                                                                            \
                                                                                     \
        __VA_ARGS__                                                                  \
        if (methods.size() > 0) { clazz.register_natives(p_env, methods); }          \
        clazz.delete_local_ref(p_env);                                               \
    }                                                                                \
                                                                                     \
private:

/**
 * This class wraps a JObject representing a JVM instance.
 * This class is a base that allows to setup JavaToNative and NativeToJava call easily.
 * One implementation must be provided for every JVM class you wish to use.
 * Use INIT_JNI_BINDINGS macro to create a static instance that will handle the JNI setup for that class.
 * Note that the jni::JObject p_wrapped argument in the constructor must be a local reference.
 * It will automatically be promoted to global and the local deleted.
 */
template<class Derived, const char* FqName>
class JvmInstanceWrapper {
protected:
    bool is_weak;
    jni::JObject wrapped;

    explicit JvmInstanceWrapper(jni::Env& p_env, jni::JObject p_wrapped);
    ~JvmInstanceWrapper();

public:
    bool is_ref_weak() const;

    const jni::JObject& get_wrapped() const;

    void swap_to_strong_unsafe(jni::Env& p_env);

    void swap_to_weak_unsafe(jni::Env& p_env);

    static const char* get_fully_qualified_name();

    static Derived* create_instance(jni::Env& p_env, ClassLoader* class_loader);
};

template<class Derived, const char* FqName>
JvmInstanceWrapper<Derived, FqName>::JvmInstanceWrapper(jni::Env& p_env, jni::JObject p_wrapped) : is_weak(false) {
    // When created, it's a strong reference by default
    wrapped = p_wrapped.new_global_ref<jni::JObject>(p_env);
    p_wrapped.delete_local_ref(p_env);
}

template<class Derived, const char* FqName>
Derived* JvmInstanceWrapper<Derived, FqName>::create_instance(jni::Env& p_env, ClassLoader* class_loader) {
    jni::JClass cls;
    if (class_loader) {
        cls = class_loader->load_class(p_env, FqName);
    } else {
        cls = p_env.find_class(FqName);
    }
    jni::MethodId ctor = cls.get_constructor_method_id(p_env, "()V");
    jni::JObject instance = cls.new_instance(p_env, ctor);
    return new Derived(p_env, instance);
}

template<class Derived, const char* FqName>
JvmInstanceWrapper<Derived, FqName>::~JvmInstanceWrapper() {
    jni::Env env {jni::Jvm::current_env()};
    if (is_weak) {
        wrapped.delete_weak_ref(env);
    } else {
        wrapped.delete_global_ref(env);
    }
}

template<class Derived, const char* FqName>
bool JvmInstanceWrapper<Derived, FqName>::is_ref_weak() const {
    return is_weak;
}

template<class Derived, const char* FqName>
void JvmInstanceWrapper<Derived, FqName>::swap_to_strong_unsafe(jni::Env& p_env) {
    // Assume the reference is currently weak
    jni::JObject new_ref = wrapped.new_global_ref<jni::JObject>(p_env);
    wrapped.delete_weak_ref(p_env);
    wrapped = new_ref;
    is_weak = false;
}

template<class Derived, const char* FqName>
void JvmInstanceWrapper<Derived, FqName>::swap_to_weak_unsafe(jni::Env& p_env) {
    // Assume the reference is currently strong
    jni::JObject new_ref = wrapped.new_weak_ref<jni::JObject>(p_env);
    wrapped.delete_global_ref(p_env);
    wrapped = new_ref;
    is_weak = true;
}

template<class Derived, const char* FqName>
const char* JvmInstanceWrapper<Derived, FqName>::get_fully_qualified_name() {
    return FqName;
}

template<class Derived, const char* FqName>
const jni::JObject& JvmInstanceWrapper<Derived, FqName>::get_wrapped() const {
    return wrapped;
}

#endif// GODOT_JVM_JVM_INSTANCE_WRAPPER_H