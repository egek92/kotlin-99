package org.kotlin99.arithmetic

import org.junit.Assert.assertTrue
import org.junit.Test

/*
 P33 (*) Determine whether two positive integer numbers are coprime.

 Two numbers are coprime if their greatest common divisor equals 1.
 */
fun Int.isCoprimeTo(n: Int) = gcd(this, n) == 1

class P33Test {
    @Test fun `determine whether two positive integer numbers are coprime`() {
        assertTrue(35.isCoprimeTo(64))
    }
}
