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

    var counterPart2 = 0

    for (row in input) {
        if (checkStringNewRules(row)) {
            counterPart2 ++
        }
    }

    println(counterPart2)

    println(checkStringNewRules("qjhvhtzxzqqjkmpb"))
    println(checkStringNewRules("xxyxx"))
    println(checkStringNewRules("uurcxstgmygtbstg"))
    println(checkStringNewRules("ieodomkazucvgmuy"))
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

fun checkStringNewRules(input : String) : Boolean {
    var doublePair = false
    var hasRepeatedLetter = false

    var currentPair = ""


    for(i in input.indices) {
        if (i+2 < input.length && input[i] == input[i+2]) {
            hasRepeatedLetter = true
        }

        if (i+1 < input.length) {
            currentPair = input[i].toString() + input[i+1].toString()

            val string = input.replace(currentPair, "")
            val count = input.length - string.length

            if (count >= 4) {
                doublePair = true
            }
        }
    }

    if (doublePair && hasRepeatedLetter) {
        return true
    }

    return false
}