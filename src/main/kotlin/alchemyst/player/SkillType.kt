package alchemyst.player

import com.google.gson.annotations.Expose
import alchemyst.registry.HasId

class SkillType(@Expose override val id: String) : HasId {
    companion object {
        @JvmStatic
        val none: SkillType =
            SkillType("alchemyst.internal.None")
    }
}