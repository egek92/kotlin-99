package org.kotlin99.arithmetic

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P31 (*) Determine whether a given integer number is prime.
 */
fun Int.isPrime(): Boolean {
    if (this <= 1)
        return false

    val sqrt = Math.sqrt(toDouble()).toInt()
    return (2..sqrt).all { this % it != 0 }
}

class P31Test {
    @Test fun `determine whether a given integer number is prime`() {
        assertThat((0..13).filter { it.isPrime() }, equalTo(
                listOf(2, 3, 5, 7, 11, 13))
        )
    }
}
