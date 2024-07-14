import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class CounterTest {
    @Test
    fun counterTest() {
        val fileName = this::class.java.classLoader.getResource("ip.txt")!!.file
        val file = File(fileName)
        val count = count(file)
        assertEquals(count, 3, "counter is wrong")
    }
}