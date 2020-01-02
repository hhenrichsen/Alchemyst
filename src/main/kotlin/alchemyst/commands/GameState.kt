package alchemyst.commands

import alchemyst.player.Player

class GameState(var localPlayer: Player) {
    var done: Boolean = false
}
