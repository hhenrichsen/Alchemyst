package alchemyst.io

import com.google.gson.Gson
import alchemyst.data.items.ItemType
import org.hjson.JsonValue
import java.io.File
import java.io.FileReader

object JsonUtil {
    private val gson = Gson()

    fun toJson(toConvert: Any): String {
        return gson.toJson(toConvert)
    }

    fun fromHjson() : Array<ItemType> {
        return gson.fromJson(JsonValue.readHjson(FileReader(File("resources/content/alchemyst/base.items.hjson"))).toString(),
            Array<ItemType>::class.java)
    }
}
