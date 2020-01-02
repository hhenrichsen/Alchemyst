package alchemyst.items

import com.google.gson.annotations.Expose
import alchemyst.Alchemyst

class Effect(@Expose val id: String, val strengthFormula: String, val requiredKnowledge: Int) {
    val effectType: EffectType = Alchemyst.registry.effects[id] ?: EffectType.none
}