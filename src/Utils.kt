import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.copyTo
import kotlin.io.path.readLines
import kotlin.io.path.writeText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)


// create a function that copies src/Day01.kt for each day in December, renaming it to Day02.kt, Day03.kt, etc.
fun main() {
    val days = (1..31).map { it.toString().padStart(2, '0') }
    days.forEach { day ->
        Path("src/Day01.kt").copyTo(Path("src/Day$day.kt"), overwrite = true)
        // create empty Day$day.txt and Day$day_test.txt files for each day
        Path("src/Day$day.txt").writeText("")
        Path("src/Day${day}_test.txt").writeText("")
    }
}