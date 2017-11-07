package org.kotlin99.arithmetic

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P40 (*) Goldbach's conjecture.

 Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
 E.g. 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be correct
 in the general case. It has been numerically confirmed up to very large numbers (much larger than Kotlin's Int
 can represent).

 Write a function to find the two prime numbers that sum up to a given even integer.
 */
fun Int.goldbach(): Pair<Int, Int> {
    val primalities = primalityMap(endInclusive = this)     /* Create map for O(1) lookup of complementary prime */
    primalities.forEach { (n, isPrime) ->
        if (isPrime && primalities[this - n] == true) {
            return Pair(n, this - n)
        }
    }

    throw RuntimeException("Goldbach numbers not found")
}

/**
 * A map of the natural numbers in range [`start`, `endInclusive`] to their primality.
 */
fun primalityMap(start: Int = 2, endInclusive: Int): Map<Int, Boolean> =
    (start..endInclusive).fold(emptyMap()) { acc, i ->
        acc + mapOf(i to i.isPrime())
    }

class P40Test {
    @Test fun `Goldbach's conjecture`() {
        assertThat(4.goldbach(), equalTo(Pair(2, 2)))
        assertThat(28.goldbach(), equalTo(Pair(5, 23)))
    }
}
