import java.io.File

fun main(args: Array<String>) {
    val fileName = "resources/input_day_1"
    // Part 1
    val changes = File(ClassLoader.getSystemResource(fileName).file)
        .readLines()
            .map { it.toInt() }
    println("Part 1 result: ${changes.sum()}")

    // Part 2
    val frequencies = mutableListOf<Int>()
    var frequency = 0
    var foundTwice = false
    while (!foundTwice) {
        changes.forEach {
            frequency += it
            if (frequencies.contains(frequency)) {
                println("Reached twice $frequency")
                foundTwice = true
            } else {
                frequencies.add(frequency)
            }
        }
    }

}

