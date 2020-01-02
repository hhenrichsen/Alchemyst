package alchemyst.registry

import alchemyst.io.TypeLoader
import alchemyst.items.EffectType
import alchemyst.items.ItemType
import alchemyst.items.QualityType
import alchemyst.items.RarityType
import alchemyst.player.SkillType

object AlchemystRegistry {
    val items = Registry<ItemType>()
    val rarity = Registry<RarityType>()
    val skills = Registry<SkillType>()
    val qualities = Registry<QualityType>()
    val effects = Registry<EffectType>()
    val typeLoaders = Registry<TypeLoader<*>>()
}