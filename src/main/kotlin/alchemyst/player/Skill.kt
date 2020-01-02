package alchemyst.player

import com.google.gson.annotations.Expose
import alchemyst.Alchemyst

class Skill(@Expose private val skillId: String, @Expose var experience: Long, @Expose var level: Int) {
    val skillType: SkillType = Alchemyst.registry.skills[skillId] ?: SkillType.none
}