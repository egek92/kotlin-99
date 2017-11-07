package org.kotlin99.arithmetic

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P32 (**) Determine the greatest common divisor of two positive integer numbers.
 Use Euclid's algorithm (https://en.wikipedia.org/wiki/Euclidean_algorithm)
 */
fun gcd(a: Int, b: Int): Int =
        if (b == 0) a
        else gcd(b, a % b)

class P32Test {
    @Test fun `greatest common divisor of two positive integer numbers`() {
        assertThat(gcd(1, 2), equalTo(1))
        assertThat(gcd(4, 2), equalTo(2))
        assertThat(gcd(5, 13), equalTo(1))
        assertThat(gcd(36, 63), equalTo(9))
    }
}
