import java.io.File
import java.util.Collections.sort

fun main() {
    val input = File("data/day2_packages").readText()

    val list = input.split("\n").map { it.trim().split("x") }

    var totalPaperNeeded = 0
    var totalRibbonLength = 0

    for (box in list) {

        val result = box.map { it.toInt() }.sorted()

        // Part 1
        val l = box[0].toInt()
        val w = box[1].toInt()
        val h = box[2].toInt()

        val s1 = l*w
        val s2 = w*h
        val s3 = h*l

        val surface =  2*s1 + 2*s2 + 2*s3

        val min = listOf(s1,s2,s3).min()

        val paperNeeded = surface + min

        totalPaperNeeded += paperNeeded

        // Part 2
        val min1 = result[0]
        val min2 = result[1]

        val ribbonLength = result.reduce { acc, element -> acc * element }

        totalRibbonLength += ribbonLength + (min1 * 2 + min2 * 2)
    }

    println(totalPaperNeeded)
    println(totalRibbonLength)
}