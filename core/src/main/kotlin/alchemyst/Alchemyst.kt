package alchemyst

import com.google.gson.Gson
import alchemyst.commands.Command
import alchemyst.state.GameState
import alchemyst.io.ItemTypeLoader
import alchemyst.player.Player
import alchemyst.registry.AlchemystRegistry

object Alchemyst {
    var commandMap = mutableMapOf<String, Command>()
    val registry = AlchemystRegistry


    @JvmStatic
    fun main(args: Array<String>) {
        loadRegistry()
        // Register commands
        registerCommands()
        // Init state
        var state = GameState(Player())
        // Start game loop
        while (!state.done) {
            val input = readLine()
            val inputs = input?.split(" ") ?: continue
            if (inputs[0] in commandMap) {
                state = commandMap[input]!!.execute(state, inputs)
            }
            else {
                println("Invalid command.")
            }
        }
    }

    private fun loadRegistry() {
        val gson = Gson()
        registry.typeLoaders.register(
            ItemTypeLoader(
                gson
            ), false)
//        JsonUtil.fromJson()
    }

    private fun registerCommands() {
        val exit = object : Command {
            override fun execute(state: GameState, arguments: List<String>): GameState {
                state.done = true
                return state
            }

            override fun getName(): String {
                return "exit"
            }
        }
        val help = object : Command {
            override fun execute(state: GameState, arguments: List<String>): GameState {
                println("Alchemyst Help:")
                for ((k, v) in commandMap) {
                    println("\t$k - ${v.getName()}")
                }
                return state
            }

            override fun getName(): String {
                return "help"
            }
        }
        commandMap["exit"] = exit
        commandMap["x"] = exit
        commandMap["help"] = help
        commandMap["?"] = help
    }
}