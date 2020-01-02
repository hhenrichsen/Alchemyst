package alchemyst.items

import alchemyst.registry.Identified

class ItemType(override val id: String, val name: String, val description: String, val rarityType: RarityType, val baseValue: Int) :
    Identified {
    val effects: List<Effect> = mutableListOf()

    companion object {
        val none = ItemType(
            "alchemyst.internal.None",
            "Nothing",
            "A whole bunch of nothing.",
            RarityType.none,
            0
        )
    }

    /**
     * Builds an [Item] of this ItemType.
     *
     * @param count The number of items.
     * @param quality The quality type this item should have.
     */
    fun getInstance(count: Int = 1, quality: QualityType) : Item {
        return Item(id, count, quality.id)
    }
}