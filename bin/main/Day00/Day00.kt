import java.io.File

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = File("input", "Day00_test.txt").readLines()
    val input = File("input", "Day00.txt").readLines()

    // val part1TestOutput = part1(testInput)
    // check(part1TestOutput == 0)
    // println(part1(input))

    // val part2TestOutput = part2(testInput)
    // check(part2TestOutput == 0)
    // println(part2(input))
}
