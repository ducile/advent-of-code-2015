import java.io.File

fun main() {
    val input = File("data/day5_input").readText().split("\n")

    var count = 0

    for (row in input) {
        if (checkString(row)) {
            count ++
        }
    }

    println(count)
}

fun checkString(input : String) : Boolean {
    val regex = Regex("(\\w)\\1+")

    if (! input.contains("ab") && ! input.contains("cd") && ! input.contains("pq") && ! input.contains("xy")) {

        var vowels = 0

        for (ch in input) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++
            }
        }

        if (input.contains('a') || input.contains('e') || input.contains('i') || input.contains('o') || input.contains('u')) {
            if (regex.containsMatchIn(input) && vowels >= 3) {
                return true
            }
        }
    }

    return false
}