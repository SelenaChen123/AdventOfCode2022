import java.io.File

fun main() {
    fun part1(input: List<String>): Int {
        var points = 0

        for (line in input) {
            val them = line.split(" ")[0]
            val you = line.split(" ")[1]

            val theirValue =
                    when (them) {
                        "A" -> 1
                        "B" -> 2
                        "C" -> 3
                        else -> 0
                    }

            val yourValue =
                    when (you) {
                        "X" -> 1
                        "Y" -> 2
                        "Z" -> 3
                        else -> 0
                    }

            if (theirValue == yourValue) {
                points += 3
            } else if (theirValue + 1 == yourValue || (theirValue == 3 && yourValue == 1)) {
                points += 6
            }

            points += yourValue
        }

        return points
    }

    fun part2(input: List<String>): Int {
        var points = 0

        for (line in input) {
            val them = line.split(" ")[0]
            val you = line.split(" ")[1]

            val theirValue =
                    when (them) {
                        "A" -> 1
                        "B" -> 2
                        "C" -> 3
                        else -> 0
                    }

            if (you == "Y") {
                points += theirValue
                points += 3
            } else if (you == "Z") {
                if (theirValue != 3) {
                    points += theirValue + 1
                } else {
                    points += 1
                }
                points += 6
            } else {
                if (theirValue != 1) {
                    points += theirValue - 1
                } else {
                    points += 3
                }
            }
        }

        return points
    }

    val testInput = File("input", "Day02_test.txt").readLines()
    val input = File("input", "Day02.txt").readLines()

    val part1TestOutput = part1(testInput)
    check(part1TestOutput == 15)
    println(part1(input))

    val part2TestOutput = part2(testInput)
    check(part2TestOutput == 12)
    println(part2(input))
}
