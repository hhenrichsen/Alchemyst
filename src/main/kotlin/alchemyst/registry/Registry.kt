package alchemyst.registry

class Registry<T : Identified> {
    private val map: MutableMap<String, T> = mutableMapOf()

    operator fun get(id: String) : T? {
        return map[id]
    }

    fun has(id: String) : Boolean {
        return id in map
    }

    fun register(item: T, overwrite: Boolean) {
        if(!overwrite || item.id in map) {
            return
        }
        map[item.id] = item
    }
}
