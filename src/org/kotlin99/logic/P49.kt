package org.kotlin99.logic

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P49 (*) Gray code.

 An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules.
 Find out the construction rules and write a function to generate Gray codes.

 For example:

 > grayCodes(bits = 1)
 [0, 1]
 > grayCodes(bits = 2)
 [00, 01, 11, 10]
 > grayCodes(bits = 3)
 [000, 001, 011, 010, 110, 111, 101, 100]
 */
fun grayCodes(bits: Int): List<String> {
    require(bits >= 1) { "bits must be >= 1" }

    if (bits == 1)
        return listOf("0", "1")

    val previous = grayCodes(bits - 1)
    return previous.map { "0" + it } + previous.reversed().map { "1" + it }
}

class P49Test {
    @Test fun `generate Gray code values`() {
        assertThat(grayCodes(bits = 1), equalTo(listOf("0", "1")))
        assertThat(grayCodes(bits = 2), equalTo(listOf("00", "01", "11", "10")))
        assertThat(grayCodes(bits = 3), equalTo(listOf("000", "001", "011", "010", "110", "111", "101", "100")))
    }
}
