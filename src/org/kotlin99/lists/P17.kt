package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P17 (*) Split a list into two parts.
 The length of the first part is given. Use a Tuple for your result. Example:
 > split(3, "abcdefghijk".toList())
 ([a, b, c], [d, e, f, g, h, i, j, k])
 */
fun <T> split(n: Int, list: List<T>) = Pair(list.take(n), list.drop(n))

class P17Test {
    @Test fun `split a list into two parts`() {
        assertThat(split(3, "abcdefghijk".toList()), equalTo(Pair("abc".toList(), "defghijk".toList())))
    }
}
