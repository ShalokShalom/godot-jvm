package godot.core

import godot.util.VoidPtr

class KtClass<T : KtObject>(
        val name: String,
        val superClass: String,
        private val constructors: Map<Int, KtConstructor<T>>,
        private val _properties: Map<String, KtProperty<T, *>>,
        private val _functions: Map<String, KtFunction<T, *>>,
        private val _signalInfos: Map<String, KtSignalInfo>
) {
    val functions: Array<KtFunction<T, *>>
        get() = _functions.values.toTypedArray()
    val properties: Array<KtProperty<T, *>>
        get() = _properties.values.toTypedArray()
    val signalInfos: Array<KtSignalInfo>
        get() = _signalInfos.values.toTypedArray()

    fun new(rawPtr: VoidPtr, instanceId: Long, constructorIndex: Int): T {
        val constructor = constructors[constructorIndex]
        check(constructor != null) { "Constructor with $constructorIndex parameter(s) not found." }
        val args = TransferContext.readArguments(*constructor.parameterTypes)
        return KtObject.instantiateWith(rawPtr, instanceId) {
            constructor(*args.toTypedArray())
        }
    }
}
