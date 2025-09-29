fun isPalindrome(s: String): Boolean {
    return s == s.reversed()
}

fun findPalindromePairs(words: List<String>): List<Pair<String, String>> {
    val result = mutableListOf<Pair<String, String>>()
    val wordSet = words.toSet()

    for (word in words) {
        for (i in 0..word.length) {
            val prefix = word.substring(0, i)
            val suffix = word.substring(i)

            if (isPalindrome(prefix)) {
                val reversedSuffix = suffix.reversed()
                if (wordSet.contains(reversedSuffix) && reversedSuffix != word) {
                    result.add(Pair(reversedSuffix, word))
                }
            }

            if (isPalindrome(suffix)) {
                val reversedPrefix = prefix.reversed()
                if (wordSet.contains(reversedPrefix) && reversedPrefix != word) {
                    result.add(Pair(word, reversedPrefix))
                }
            }
        }
    }

    return result.distinct()
}

fun main() {
    val words = listOf("кот", "ток", "рот", "тор", "код", "док")
    val palindromePairs = findPalindromePairs(words)
    println("Найденные палиндромные пары:")
    for (pair in palindromePairs) {
        println("${pair.first} + ${pair.second} = ${pair.first + pair.second}")
    }
}
