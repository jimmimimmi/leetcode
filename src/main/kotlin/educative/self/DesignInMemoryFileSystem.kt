package educative.self

import java.util.*

// https://leetcode.com/problems/design-in-memory-file-system/description/
class DesignInMemoryFileSystem {
    data class Node(
        val name: String,
        val isFolder: Boolean = true,
        var fileContent: String = "",
        val childs: TreeMap<String, Node> = TreeMap<String, Node>(),
    )

    val root = Node("")

    fun ls(path: String): List<String> {
        kotlin.math.abs(1)
        if (!path.startsWith("/")) return listOf()
        var curNode = root
        // println("\nls $path. Begin. curNode $curNode")
        if (path != "/") {
            val paths = path.drop(1).split("/")

            for (i in 0 until paths.size) {
                val child = curNode.childs[paths[i]]
                if (child == null) return listOf()
                if (i != paths.size - 1 && !child.isFolder) return listOf()
                if (i == paths.size - 1 && !child.isFolder) return listOf(child.name)
                curNode = child
            }
        }
        val res = curNode.childs.entries.map { it.key }
        // println("ls $path. End. curNode $curNode, res $res")
        return res
    }

    fun mkdir(path: String) {
        if (!path.startsWith("/")) return
        val paths = path.drop(1).split("/")
        var curNode = root
        // println("\nmkdir $path. Begin. curNode $curNode")
        for (i in 0 until paths.size) {
            var child = curNode.childs[paths[i]]
            if (child == null) {
                child = Node(paths[i])
                curNode.childs[paths[i]] = child
            }
            curNode = child
        }
        // println("mkdir $path. End. curNode $curNode")
    }

    private fun getFileNode(path: String): Node {
        if (!path.startsWith("/")) return root
        var curNode = root
        // println("\n\tgetFileNode $path. Begin. curNode $curNode")
        if (path != "/") {
            val paths = path.drop(1).split("/")

            for (i in 0 until paths.size) {
                var child = curNode.childs[paths[i]]
                if (child == null) {
                    child = Node(paths[i], i != paths.size - 1)
                    curNode.childs[paths[i]] = child
                }
                curNode = child
            }
        }
        //  println("\tgetFileNode $path. End. curNode $curNode")
        return curNode
    }

    fun addContentToFile(filePath: String, content: String) {
        // println("\naddContentToFile $filePath. Begin")
        val fileNode = getFileNode(filePath)

        // println("addContentToFile $filePath. End. fileNode $fileNode")
        fileNode.fileContent += content
    }

    fun readContentFromFile(filePath: String): String {
        // println("\nreadContentFromFile $filePath. Begin")
        val fileNode = getFileNode(filePath)

        // println("readContentFromFile $filePath. End. fileNode $fileNode")
        return fileNode.fileContent
    }
}
