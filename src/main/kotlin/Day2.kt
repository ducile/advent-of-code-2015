import java.io.File

fun main() {
    val input = File("data/day2_packages").readText()

    val list = input.split("\n").map { it.trim().split("x") }

    var totalPaperNeeded = 0

    for (box in list) {
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
    }

    println(totalPaperNeeded)
}