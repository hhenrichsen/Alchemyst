package alchemyst.commands

interface Command {
    fun execute(state: GameState, arguments: List<String>) : GameState
    fun getName() : String
}