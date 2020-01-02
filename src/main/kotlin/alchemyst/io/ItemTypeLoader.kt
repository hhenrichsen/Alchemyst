package alchemyst.io

import com.google.gson.Gson
import alchemyst.Alchemyst
import alchemyst.items.ItemType
import alchemyst.registry.Registry

class ItemTypeLoader(gson: Gson) : TypeLoader<ItemType>(gson) {
    override val typeName: String = "items"
    override val registry: Registry<ItemType> = Alchemyst.registry.items

    override fun loadType(text: String, packageName: String): ItemType? {
        val item = gson.fromJson(text, ItemType::class.java)
        if(!item.id.startsWith(packageName)) {
            println("Error while loading item ${item.id}: ID does not match actual package $packageName. Refusing to load item.")
            return null
        }
        return item
    }

}