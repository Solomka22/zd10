
import java.util.*
class GameNavigator {
    //1
    fun rungd1() {
        val scanner = Scanner(System.`in`)
        println("введите натуральное число n:")
        val n = scanner.nextInt()
        println(printNumber(n))
    }
    //2
    fun rungd2() {
        val scanner = Scanner(System.`in`)
        println("введите количество уровней пирамиды:")
        val n = scanner.nextInt()
        pyramid(n)
    }
    //3
    fun rungd3() {
        val scanner = Scanner(System.`in`)
        println("введите текст для шифрования:")
        val text = scanner.nextLine()
        println("введите смещение (число):")
        val shift = scanner.nextInt()
        println("зашифрованный текст: ${caesarCipher(text, shift)}")
    }
    //4
    fun rungd4() {
        val scanner = Scanner(System.`in`)
        println("введите натуральное число n:")
        val n = scanner.nextInt()
        println(fizzBuzz(n))
    }
    private fun printNumber(n: Int): List<Int> {
        return if (n <= 0) {
            emptyList()
        } else {
            (n downTo 1).toList()
        }
    }
    private fun pyramid(n: Int) {
        for (i in 1..n) {
            val spaces = " ".repeat(n - i)
            val hashes = "#".repeat(2 * i - 1)
            println("$spaces$hashes$spaces")
        }
    }
    private fun caesarCipher(text: String, shift: Int): String {
        return text.map { char ->
            when {
                char.isUpperCase() -> ((char.toInt() + shift - 65) % 26 + 65).toChar()
                char.isLowerCase() -> ((char.toInt() + shift - 97) % 26 + 97).toChar()
                else -> char
            }
        }.joinToString("")
    }
    //5
    private fun fizzBuzz(n: Int): List<Any> {
        return (1..n).map {
            when {
                it % 3 == 0 && it % 5 == 0 -> "визллбизлл"
                it % 3 == 0 -> "физллл"
                it % 5 == 0 -> "бизлллл"
                else -> it
            }
        }
    }
}
fun main() {
    val scanner = Scanner(System.`in`)
    val gameNavigator = GameNavigator()
    while (true) {
        println("\nвыберите задание:")
        println("1. числа от n до 1")
        println("2. генерация пирамиды")
        println("3. шифр цезаря")
        println("4. fizzbuzz")
        println("5. выход")
        when (scanner.nextLine()) {
            "1" -> gameNavigator.rungd1()
            "2" -> gameNavigator.rungd2()
            "3" -> gameNavigator.rungd3()
            "4" -> gameNavigator.rungd4()
            "5" -> {
                println("выход из заданий")
                return
            }
            else -> println("некорректный выбор")
        }
    }
}