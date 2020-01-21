package alchemyst.data.items

import com.google.gson.annotations.Expose
import alchemyst.player.Player
import alchemyst.io.EquationCompileException
import alchemyst.registry.Identified
import java.io.PrintWriter
import java.io.StringWriter
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

class EffectType(@Expose override val id: String, @Expose val name: String, @Expose val levelFormula: String, @Expose val valueFormula: String) :
    Identified {
    companion object {
        private val scriptEngine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        private val stringWriter = StringWriter()
        private val printWriter = PrintWriter(stringWriter)
        private val errorStringWriter = StringWriter()
        private val errorPrintWriter = PrintWriter(errorStringWriter)
        init {
            scriptEngine.context.writer =
                printWriter
            scriptEngine.context.errorWriter =
                errorStringWriter
        }

        val none = EffectType("alchemyst.internal.None", "None", "0", "0")
    }

    fun getLevel(player: Player, instance: Item) : Int {
        scriptEngine.eval("P = " + player.toJson())
        scriptEngine.eval("S = " + instance.toJson())
        if (errorStringWriter.buffer.isNotEmpty()) {
            throw EquationCompileException("Error in level formula resulted in a non-integer return. Formula: $levelFormula")
        }
        scriptEngine.eval("P = {}")
        scriptEngine.eval("S = {}")
        return try {
            stringWriter.buffer.toString().toInt()
        } catch (e: NumberFormatException) {
            throw EquationCompileException("Error in level formula resulted in a non-integer return. Formula: $levelFormula")
        }
    }

    fun getInstance(strengthFormula: String, requiredKnowledge: Int): Effect {
        return Effect(id, strengthFormula, requiredKnowledge)
    }
}