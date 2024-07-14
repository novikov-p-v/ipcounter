import java.io.File
import java.util.*

fun count(file: File): Int {
    val arr = Array(256){ Array(256) {Array(256) { BitSet(256) } } }
    var counter = 0
    var batchCounter = 0
    var lineCounter: Long = 0
    file.forEachLine { line ->
        val ip = line.split(".")
            .map { it.toInt() }
        val alreadyExists = arr[ip[0]][ip[1]][ip[2]][ip[3]]
        if (!alreadyExists) {
            arr[ip[0]][ip[1]][ip[2]][ip[3]] = true
            counter++
        }
        batchCounter++
        lineCounter++
        if (batchCounter >= 1000000) {
            println("Обработано строк: $lineCounter")
            batchCounter = 0
        }
    }
    return counter
}