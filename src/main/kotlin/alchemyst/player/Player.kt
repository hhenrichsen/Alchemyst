package alchemyst.player

import alchemyst.io.JsonUtil

class Player {
    val inventory: Inventory by lazy {
        Inventory(this)
    }

    var skills: MutableList<Skill> = mutableListOf()

    fun toJson() : String {
        return JsonUtil.toJson(this)
    }
}
