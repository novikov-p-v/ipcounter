import java.io.File
/**
 * Программа подсчитывает количество уникальных ip в файле.
 * Путь к файлу - первый аргумент запуска прогруммы в командной строке.
 * Делаем четырех мерный массив размером 256x256x256 типа BitSet.
 * Идем по строкам в файле. Парсим ip в 4 числа. На соответвующее место массива ставим true
 * и увеличиваем сечтик. Потребляемая память равна размеру массива
 */
fun main(arg: Array<String>) {
    val timeStart = System.currentTimeMillis()
    if (arg.isEmpty()) {
        println("Не указано имя файла")
    }
    val counter = count(File(arg[0]))
    val timeEnd = System.currentTimeMillis()
    println("Время сек: ${(timeEnd - timeStart)/1000}")
    println("Total memory ${Runtime.getRuntime().totalMemory()}")
    println("Уникальных записей $counter")
}
