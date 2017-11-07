package org.kotlin99.arithmetic

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P41 (*) A list of Goldbach compositions.

  Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition.
  > printGoldbachList(9..20)
  10 = 3 + 7
  12 = 5 + 7
  14 = 3 + 11
  16 = 3 + 13
  18 = 5 + 13
  20 = 3 + 17
 */
fun goldbachList(range: IntRange): List<Pair<Int, Int>> {
    // Round start & end to evens in range
    val start = if (range.start % 2 == 1) range.start + 1 else range.start
    val end = if (range.endInclusive % 2 == 1) range.endInclusive - 1 else range.endInclusive
    val evenRange = (start..end) step 2

    return evenRange.fold(emptyList()) { acc, n ->
        acc + n.goldbach()
    }
}

fun printGoldbachList(range: IntRange) =
        goldbachList(range).forEach { goldbach  ->
            println("${goldbach.first + goldbach.second} = ${goldbach.first} + ${goldbach.second}")
        }

class P41Test {
    @Test fun `list of Goldbach compositions`() {
        printGoldbachList(9..20)
        assertThat(goldbachList(9..20), equalTo(listOf(
            Pair(3, 7),
            Pair(5, 7),
            Pair(3, 11),
            Pair(3, 13),
            Pair(5, 13),
            Pair(3, 17)
        )))
    }

}
