package alchemyst.commands

import alchemyst.state.GameState

interface Command {
    fun execute(state: GameState, arguments: List<String>) : GameState
    fun getName() : String
}