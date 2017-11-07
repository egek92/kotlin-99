package org.kotlin99.arithmetic

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P39 (*) A list of prime numbers.

 Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.

 > listPrimesInRange(7..31)
 [7, 11, 13, 17, 19, 23, 29, 31]
 */
fun listPrimesInRange(range: IntRange): List<Int> =
        (range.start..range.endInclusive).filter { it.isPrime() }

class P39Test {
    @Test fun `list of prime numbers`() {
        assertThat(listPrimesInRange(7..31), equalTo(listOf(7, 11, 13, 17, 19, 23, 29, 31)))
    }
}
