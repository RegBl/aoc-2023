fun main() {
    val numberWords = arrayOf(
        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
    )

    fun part1(input: List<String>): Int {
        val numbers = input.map { line ->
            line.filter { c -> c.isDigit() }
                .let { "${it.first()}${it.last()}" }
                .toInt()
        }
        return numbers.sum()
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
