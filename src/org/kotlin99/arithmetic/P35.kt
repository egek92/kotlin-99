package org.kotlin99.arithmetic

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P35 (*) Determine prime factors of a given positive integer.

 Construct a list containing prime factors in ascending order.

 > 315.primeFactors()
 [3, 3, 5, 7]
 */
fun Int.primeFactors(): List<Int> {
    if (this < 2) return emptyList()

    val primeFactors = mutableListOf<Int>()
    var remainder = this
    var i = 2
    while (i <= remainder / i) {
        while (remainder % i == 0) {
            primeFactors.add(i)
            remainder /= i
        }

        i++
    }

    if (remainder > 1)
        primeFactors.add(remainder)

    return primeFactors
}

class P35Test {
    @Test fun `determine prime factors of a given positive integer`() {
        assertThat((2..10).map{ Pair(it, it.primeFactors()) }, equalTo(listOf(
                Pair(2, listOf(2)),
                Pair(3, listOf(3)),
                Pair(4, listOf(2, 2)),
                Pair(5, listOf(5)),
                Pair(6, listOf(2, 3)),
                Pair(7, listOf(7)),
                Pair(8, listOf(2, 2, 2)),
                Pair(9, listOf(3, 3)),
                Pair(10, listOf(2, 5))
        )))
        assertThat(315.primeFactors(), equalTo(listOf(3, 3, 5, 7)))
    }
}
