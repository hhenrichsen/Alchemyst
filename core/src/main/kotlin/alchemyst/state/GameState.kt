package alchemyst.state

import alchemyst.player.Player
import alchemyst.state.GameDate

class GameState(var localPlayer: Player) {
    var done: Boolean = false
    var date: GameDate = GameDate()
}
