package alchemyst.player

import com.google.gson.annotations.Expose
import alchemyst.registry.Identified

class SkillType(@Expose override val id: String) : Identified {
    companion object {
        @JvmStatic
        val none: SkillType =
            SkillType("alchemyst.internal.None")
    }
}