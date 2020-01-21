package alchemyst.data.items

import alchemyst.registry.Identified

class RarityType(override val id: String, val name: String) :
    Identified {
    companion object {
        val none: RarityType =
            RarityType("alchemyst.internal.None", "None")
    }
}
