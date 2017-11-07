package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.common.tail

/*
 P18 (**) Extract a slice from a list.
 Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to
 but not including the Kth element of the original list. Start counting the elements with 0.
 Example:
 > slice(3, 7, "abcdefghijk".toList())
 [d, e, f, g]
 */
fun <T> slice(i: Int, k: Int, list: List<T>): List<T> = list.slice((i until k))

@Suppress("unused")
fun <T> slice_(from: Int, to: Int, list: List<T>) = list.subList(from, to)

class P18Test {
    @Test fun `extract a slice from a list`() {
        assertThat(slice(0, 0, "".toList()), equalTo("".toList()))
        assertThat(slice(0, 4, "abcd".toList()), equalTo("abcd".toList()))
        assertThat(slice(0, 3, "abcd".toList()), equalTo("abc".toList()))
        assertThat(slice(1, 4, "abcd".toList()), equalTo("bcd".toList()))
        assertThat(slice(1, 3, "abcd".toList()), equalTo("bc".toList()))
        assertThat(slice(3, 7, "abcdefghijk".toList()), equalTo("defg".toList()))
    }
}
