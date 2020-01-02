package alchemyst.items

import alchemyst.registry.HasId

class QualityType(override val id: String, val name: String, val modifier: Float) :
    HasId {
    companion object {
        @JvmStatic val none = QualityType("alchemyst.internal.None", "None", 1.0f)
    }
}