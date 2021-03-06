#ifndef GODOT_JVM_NODE_PATH_BRIDGE_H
#define GODOT_JVM_NODE_PATH_BRIDGE_H


#include <modules/kotlin_jvm/src/java_instance_wrapper.h>

namespace bridges {

    class NodePathBridge : JavaInstanceWrapper<NodePathBridge> {
    public:
        NodePathBridge(jni::JObject p_wrapped, jni::JObject p_class_loader);
        ~NodePathBridge() = default;

        static uintptr_t engine_call_constructor(JNIEnv* p_raw_env, jobject p_instance, jboolean has_param);

        static void engine_call_path(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getName(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getNameCount(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getProperty(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getSubname(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getSubnameCount(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_isAbsolute(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_isEmpty(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_getConcatenatedSubnames(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_equals(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr);

        DECLARE_JNI_METHODS()
    };
}


#endif //GODOT_JVM_NODE_PATH_BRIDGE_H
