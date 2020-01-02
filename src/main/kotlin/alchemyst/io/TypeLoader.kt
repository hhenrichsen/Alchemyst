package alchemyst.io

import com.google.gson.Gson
import alchemyst.registry.HasId
import alchemyst.registry.HasIdExtractor
import alchemyst.registry.Registry

abstract class TypeLoader<T : HasId>(val gson: Gson) : HasIdExtractor() {
    abstract val typeName: String
    abstract val registry: Registry<T>
    abstract fun loadType(text: String, packageName: String) : T?

    fun addContent(text: String, packageName: String) {
        registry.register(loadType(text, packageName) ?: return, false)
    }

    override fun extractId(): String {
        return typeName
    }
}