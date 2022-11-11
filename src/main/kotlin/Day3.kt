import java.io.File

fun main() {
    val input = File("data/day3_movements").readText()

    var x = 0
    var y = 0

    var touchedPoints = mutableListOf(0 to 0)

    for (direction in input) {
        if (direction == '>') {
            x += 1
        } else if (direction == '^') {
            y += 1
        } else if (direction == '<') {
            x -= 1
        } else {
            y -= 1
        }

        val currentPoint = x to y

        if (! touchedPoints.contains(currentPoint)) {
            touchedPoints.add(currentPoint)
        }

    }

    println(touchedPoints.count())
}