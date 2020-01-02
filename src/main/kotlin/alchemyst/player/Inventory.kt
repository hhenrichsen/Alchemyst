package alchemyst.player

import alchemyst.items.Item

class Inventory(val owner: Player) {
    val items: MutableList<Item> = mutableListOf()
}
