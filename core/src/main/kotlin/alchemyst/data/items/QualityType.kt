package alchemyst.data.items

import alchemyst.registry.Identified

class QualityType(override val id: String, val name: String, val modifier: Float) :
    Identified {
    companion object {
        @JvmStatic val none =
            QualityType("alchemyst.internal.None", "None", 1.0f)
    }
}