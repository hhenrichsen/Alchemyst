package alchemyst.items

import alchemyst.registry.HasId

class RarityType(override val id: String, val name: String) :
    HasId {
    companion object {
        val none: RarityType =
            RarityType("alchemyst.internal.None", "None")
    }
}
