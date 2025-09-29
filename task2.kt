fun encodeWord(word: String): String {
    val map = mutableMapOf<Char, Int>()
    val result = StringBuilder()
    var counter = 0

    for (char in word) {
        if (!map.containsKey(char)) {
            map[char] = counter++
        }
        result.append(map[char])
    }

    return result.toString()
}

fun main() {
    val words = listOf("программа", "алгоритм")
    for (word in words) {
        println("$word -> ${encodeWord(word)}")
    }
}
