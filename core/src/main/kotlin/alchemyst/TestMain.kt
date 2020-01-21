package alchemyst

import alchemyst.io.JsonUtil

object TestMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val items = JsonUtil.fromHjson()
        for(item in items) {
            println(item.effects[0].effectType)
        }
    }
}