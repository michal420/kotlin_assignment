import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Comparator
import kotlin.random.Random

fun main(args: Array<String>) {

    // 1. Filter odd numbers
//    println("Filter odd numbers: ${filterOddNumbers(listOf(1, 2, 3,  4, 5))}")

    // 2. Product
//    println("Calculate product: ${calculateProduct(listOf(3, 5, 4))}")

    // 3. Capitalize first character
//    println("Capitalize first letter: ${capitalizeFirstLetter(listOf("global", "shares", "clonakilty"))}")

    // 4. Capitalize every word in the string
//    println("${capitalizeEveryWordInTheString("working in global shares")}")

    //5. Print symbols n number of times
//    println("Print character: ")
//    printTriangleForSymbolInRows('*', 5)

    //6. Print random string
//    println(returnRandomStringFromList(listOf("First", "Second", "Third")))

    // 7 Return highest value share
//    println("Highest value share: ${returnHighestValueShare(sharesList)}")

    // 8. Print awarded fate for shares
//    printAwardedDateForShares(sharesList)

    // 9. Sum of all shares
//    println("Sum of all shares: ${getSumForShares(sharesList)}")

    // 10. Update value
    println(updatePNQOAwardValue(sharesList))

} // end main()

// 1
fun filterOddNumbers(nums: List<Int>): List<Int> {
    return nums.filter { n ->
        n % 2 == 1
    }
}

// 2
fun calculateProduct(nums: List<Int>): Int {
    var result = 1
    nums.forEach {
        result *= it
    }
    return result
}

// 3
fun capitalizeFirstLetter(words: List<String>): List<String> {
    val transform: (String) -> String = {
        it.first().uppercase() + it.drop(1)
    }
    return words.map(transform)
}

// 4
fun capitalizeEveryWordInTheString(sentence: String): String {
    return sentence.split(" ").joinToString(" ") { s ->
        s.replaceFirstChar {
            it.uppercase()
        }
    }
}

// 5
fun printTriangleForSymbolInRows(c: Char, num: Int): Unit {
    val maxRows = 10
    if (num > maxRows) {
        println("Too many rows, please try again")
    } else {
        for (i in 1..num) {
            for (j in 1..i) {
                print(c)
            }
            println()
        }
    }
}

// 5 Alternative solution - if you need
fun printTriangleForSymbolInRowsAntonio(symbol: String, number: Int) {
    if (number >= 10) {
        println("Too many numbers")
        return
    }

    for (i in 1..number) {
        val str: String = symbol.repeat(i)
        println(str)
    }
}

// 6
fun returnRandomStringFromList(strings: List<String>): String {
    val i = Random.nextInt(0, strings.size)
    return strings[i]
}

//7
fun returnHighestValueShare(shares: List<Share>): Share {
    return shares.maxBy { it.value }
}

data class Share(val id: Int, val title: String, val value: Double, val awardedDate: String)

// 8
fun printAwardedDateForShares(shares: List<Share>) {
    var dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    shares.forEach {
        println("${it.title} was awarded on ${LocalDate.parse(it.awardedDate).format(dateTimeFormatter)}")
    }
}

// 9.
fun getSumForShares(shares: List<Share>): Double {
    return shares.sumOf {
        it.value
    }
}

// 10
fun updatePNQOAwardValue(shares: List<Share>): List<Share> {
    val newShares = sharesList.toMutableList()
    shares.forEachIndexed { index, share ->
        if (share.title == "PNQO Award") {
            val replacement = newShares[index].copy(
                id = share.id,
                title = share.title,
                value = 3000.00,
                awardedDate = share.awardedDate
            )
            newShares[index] = replacement
        }
    }
    return newShares
}

fun updateTheFirstItemInTheList(shares: List<Share>): List<Share> {
    val newList = sharesList.toMutableList()
    shares.forEachIndexed { index, share ->        if (share.id == 2) {
        val replacement = newList[index].copy(
            id = share.id,
            title = share.title,
            value = 3000.00,
            awardedDate = share.awardedDate
        )
        newList[index] = replacement
    }
    }
    return newList
}
