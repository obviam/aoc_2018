import java.io.File

fun main(args: Array<String>) {
    val fileName = "resources/input_day_2"
    // Part 1
    val lines = File(ClassLoader.getSystemResource(fileName).file)
        .readLines()


    var twice = 0;
    var thrice = 0;

    var found2 = false
    var found3 = false

    lines.forEach { line ->
        val lineArray = line.toCharArray()
        val chars = lineArray.distinct()
        chars.forEach{
            val count = lineArray.filter { c -> c == it }.count()
            when(count) {
                2 -> found2 = true
                3 -> found3 = true
            }
        }
        if (found2) {
            twice++
        }
        if (found3) {
            thrice++
        }
        found2 = false
        found3 = false
    }
    println("Found 2 = $twice")
    println("Found 3 = $thrice")

    println("Result = ${twice * thrice}")


    // Part 2
    for ((index, line) in lines.withIndex()) {
        for (line2 in lines.subList(index, lines.size - 1)) {
            if (diffsInSamePlace(line, line2) == 1) {
                println("Part 2 result: ${getDiffsInSamePlace(line, line2)}")
            }
        }
    }


}

fun diffsInSamePlace(val1: String, val2: String): Int {
    var diffs = 0
    for ((index, ch) in val1.withIndex()) {
        if (ch != val2[index]) {
            diffs++
        }
    }
    return diffs
}

fun getDiffsInSamePlace(val1: String, val2: String): String {
    var result = ""
    for ((index, ch) in val1.withIndex()) {
        if (ch == val2[index]) {
            result += ch
        }
    }
    return result
}

