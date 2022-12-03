import java.io.File

fun main() {
    fun part1(input: List<String>): Int {
        var globalMax = 0
        var localMax = 0

        for (line in input) {
            if (line != "") {
                localMax = localMax + line.toInt()
            } else {
                if (localMax.compareTo(globalMax) > 0) {
                    globalMax = localMax
                }

                localMax = 0
            }
        }

        return globalMax
    }

    fun part2(input: List<String>): Int {
        var max = ArrayList<Int>()
        var localMax = 0

        for (index in 0..input.size - 1) {
            if (input[index] != "") {
                localMax = localMax + input[index].toInt()
            } else {
                max.add(localMax)

                if (index != input.size - 1) {
                    localMax = 0
                }
            }
        }

        max.add(localMax)
        max.sort()

        return max[max.size - 1] + max[max.size - 2] + max[max.size - 3]
    }

    val testInput = File("input", "Day01_test.txt").readLines()
    val input = File("input", "Day01.txt").readLines()

    val part1TestOutput = part1(testInput)
    check(part1TestOutput == 24000)
    println(part1(input))

    val part2TestOutput = part2(testInput)
    check(part2TestOutput == 45000)
    println(part2(input))
}
