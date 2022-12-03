import java.io.File

fun main() {
    fun part1(input: List<String>): Int {
        var priorities = 0

        for (line in input) {
            val firstHalf = line.substring(0..line.length / 2 - 1).toSet()
            val secondHalf = line.substring(line.length / 2).toSet()
            val intersect = (firstHalf intersect secondHalf).first()

            if (intersect.isLowerCase()) {
                priorities += intersect - 'a' + 1
            } else {
                priorities += intersect - 'A' + 27
            }
        }

        return priorities
    }

    fun part2(input: List<String>): Int {
        var priorities = 0

        for (index in 0..input.size - 1 step 3) {
            val group1 = input[index].substring(0..input[index].length - 1).toSet()
            val group2 = input[index + 1].substring(0..input[index + 1].length - 1).toSet()
            val group3 = input[index + 2].substring(0..input[index + 2].length - 1).toSet()
            val intersect = (group1 intersect group2 intersect group3).first()

            if (intersect.isLowerCase()) {
                priorities += intersect - 'a' + 1
            } else {
                priorities += intersect - 'A' + 27
            }
        }

        return priorities
    }

    val testInput = File("input", "Day03_test.txt").readLines()
    val input = File("input", "Day03.txt").readLines()

    val part1TestOutput = part1(testInput)
    check(part1TestOutput == 157)
    println(part1(input))

    val part2TestOutput = part2(testInput)
    check(part2TestOutput == 70)
    println(part2(input))
}
