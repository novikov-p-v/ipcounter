import java.io.File
import java.util.BitSet

/**
 * Программа подсчитывает количество уникальных ip в файле.
 * Путь к файлу - первый аргумент запуска прогруммы в командной строке.
 * Делаем четырех мерный массив размером 256x256x256 типа BitSet.
 * Идем по строкам в файле. Парсим ip в 4 числа. На соответвующее место массива ставим true
 * и увеличиваем сечтик. Потребляемая память равна размеру массива
 */
fun main(arg: Array<String>) {
    val timeStart = System.currentTimeMillis()
    val arr = Array(256){ Array(256) {Array(256) { BitSet(256)} } }
    var counter = 0
    var batchCounter = 0
    var lineCounter: Long = 0
    if (arg.isEmpty()) {
        println("Не указано имя файла")
    }
    File(arg[0]).forEachLine { line ->
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
    val timeEnd = System.currentTimeMillis()
    println("Время сек: ${(timeEnd - timeStart)/1000}")
    println("Total memory ${Runtime.getRuntime().totalMemory()}")
    println("Уникальных записей $counter")
}
