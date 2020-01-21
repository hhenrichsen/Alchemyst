package alchemyst.player

import alchemyst.data.items.Item

class Inventory(val owner: Player) {
    val items: MutableList<Item> = mutableListOf()
}
