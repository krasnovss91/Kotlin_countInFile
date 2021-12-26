import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import java.io.File
import java.io.FileInputStream
import java.util.*

suspend fun main() = coroutineScope {
    val file1 = File("sample1.txt")
    val file2 = File("sample2.txt")
    val file3 = File("sample3.txt")

    val call1 = async { countInFiles(file1) }
    val call2 = async { countInFiles(file2) }
    val call3 = async { countInFiles(file3) }

    println(call1.await() + call2.await() + call3.await())

}

suspend fun countInFiles(file: File):Int{
    delay(100)
    val sc = Scanner(FileInputStream(file))
    var count = 0
    while (sc.hasNext()) {
        sc.next()
        count++
    }
    return count
}