package alchemyst.registry

abstract class HasIdExtractor : HasId {
    override val id: String
        get() = extractId()

    abstract fun extractId() : String
}