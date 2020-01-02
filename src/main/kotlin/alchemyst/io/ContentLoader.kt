package alchemyst.io

import com.google.gson.Gson
import java.io.File

class ContentLoader {

    companion object {
        val gson: Gson = Gson()
        val fileRegex: Regex = Regex(".*\\.(\\w*)\\.([h]?json)$")
    }

    fun load() : Boolean {
        val contentDir = File("resources", "content")
        if(!contentDir.exists()) {
            contentDir.mkdirs()
        }
        if(!contentDir.isDirectory) {
            println("Invalid data format: resources or resources/content is not a directory.")
            return false
        }
        else if(contentDir.listFiles() == null) {
            println("An error occurred while trying to load directories in resources/content: cannot list files in directory.")
            return false
        }
        for(dir in contentDir.listFiles()!!) {
            if(dir.isDirectory) {
                loadContent(dir, "")
            }
        }
        return true
    }

    private fun loadContent(dir: File, packageName: String) {
        val newPackageName = packageName + dir.name
        for(child in dir.listFiles()!!) {
            if(child.isDirectory) {
                loadContent(child, newPackageName)
            }
            else if(child.isFile) {
                print(fileRegex.find(child.name)?.groupValues?.get(1))
            }
        }
    }
}