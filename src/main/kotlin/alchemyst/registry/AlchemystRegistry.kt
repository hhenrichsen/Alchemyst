package alchemyst.registry

import alchemyst.io.TypeLoader
import alchemyst.data.items.EffectType
import alchemyst.data.items.ItemType
import alchemyst.data.items.QualityType
import alchemyst.data.items.RarityType
import alchemyst.player.SkillType

object AlchemystRegistry {
    val items = Registry<ItemType>()
    val rarity = Registry<RarityType>()
    val skills = Registry<SkillType>()
    val qualities = Registry<QualityType>()
    val effects = Registry<EffectType>()
    val typeLoaders = Registry<TypeLoader<*>>()
}