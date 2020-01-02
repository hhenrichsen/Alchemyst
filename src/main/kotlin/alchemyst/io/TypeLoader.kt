package alchemyst.io

import com.google.gson.Gson
import alchemyst.registry.Identified
import alchemyst.registry.Identifiable
import alchemyst.registry.Registry

abstract class TypeLoader<T : Identified>(val gson: Gson) : Identifiable() {
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