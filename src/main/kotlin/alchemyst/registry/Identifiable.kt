package alchemyst.registry

abstract class Identifiable : Identified {
    override val id: String
        get() = extractId()

    abstract fun extractId() : String
}