package alchemyst.data.items

import com.google.gson.annotations.Expose
import alchemyst.Alchemyst
import alchemyst.io.JsonUtil

class Item(@Expose private val itemId: String, @Expose val count: Int, @Expose val qualityId: String) {
    val itemType: ItemType = Alchemyst.registry.items[itemId] ?: ItemType.none
    val qualityType: QualityType = Alchemyst.registry.qualities[qualityId] ?: QualityType.none
    @Expose val value = itemType.baseValue

    fun toJson(): String {
        return JsonUtil.toJson(this)
    }
}