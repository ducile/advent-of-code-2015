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

    println("Part 1: " + touchedPoints.count())

    // Part 2

    var santaX = 0
    var santaY = 0

    var roboX = 0
    var roboY = 0

    var deliveredPoints = mutableListOf(0 to 0)

    for (i in input.indices) {
        if (i % 2 == 0) {
            when (input[i]) {
                '>' -> santaX += 1
                '^' -> santaY += 1
                '<' -> santaX -= 1
                else -> santaY -= 1
            }
            val currentPoint = santaX to santaY

            if (! deliveredPoints.contains(currentPoint)) {
                deliveredPoints.add(currentPoint)
            }
        } else {
            when (input[i]) {
                '>' -> roboX += 1
                '^' -> roboY += 1
                '<' -> roboX -= 1
                else -> roboY -= 1
            }

            val currentPoint = roboX to roboY

            if (! deliveredPoints.contains(currentPoint)) {
                deliveredPoints.add(currentPoint)
            }
        }
    }

    println("Part 2: " + deliveredPoints.count())
}