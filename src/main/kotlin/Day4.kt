import java.math.BigInteger
import java.security.MessageDigest


fun md5(input:String): String {
    val md = MessageDigest.getInstance("MD5")

    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}

fun main() {
    val input = "bgvyzdsv"
    var count = 0
    var searching = true

    val testHash = md5("abcdef609043")

    if (testHash.substring(0, 5) == "00000") {
        println(testHash)
    }

    while(searching) {
        val message = input + count
        val hash = md5(message)

        if (hash.substring(0, 5) == "00000") { // Part 2: hash.substring(0, 6) == "000000"
            searching = false
            println(count)
        }

        count ++
    }
}
