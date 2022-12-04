import java.io.File

fun main() {
    fun part1(input: List<String>): Int {
        var duplicates = 0

        for (line in input) {
            val first = line.split(",")[0].split("-")
            val second = line.split(",")[1].split("-")

            if ((second[0].toInt() in first[0].toInt()..first[1].toInt() &&
                            second[1].toInt() in first[0].toInt()..first[1].toInt()) ||
                            (first[0].toInt() in second[0].toInt()..second[1].toInt() &&
                                    first[1].toInt() in second[0].toInt()..second[1].toInt())
            ) {
                duplicates++
            }
        }

        return duplicates
    }

    fun part2(input: List<String>): Int {
        var duplicates = 0

        for (line in input) {
            val first = line.split(",")[0].split("-")
            val second = line.split(",")[1].split("-")

            if (second[0].toInt() in first[0].toInt()..first[1].toInt() ||
                            second[1].toInt() in first[0].toInt()..first[1].toInt() ||
                            first[0].toInt() in second[0].toInt()..second[1].toInt() ||
                            first[1].toInt() in second[0].toInt()..second[1].toInt()
            ) {
                duplicates++
            }
        }

        return duplicates
    }

    val testInput = File("input", "Day04_test.txt").readLines()
    val input = File("input", "Day04.txt").readLines()

    val part1TestOutput = part1(testInput)
    check(part1TestOutput == 2)
    println(part1(input))

    val part2TestOutput = part2(testInput)
    check(part2TestOutput == 4)
    println(part2(input))
}
