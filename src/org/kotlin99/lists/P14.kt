package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P14 (*) Duplicate the elements of a list.

 Example:

 > duplicate("abccd".toList())
 [a, a, b, b, c, c, c, c, d, d]
 */
fun <T> duplicate(list: List<T>): List<T> =
        list.fold(emptyList()) { acc, x ->
            acc + x + x
        }

class P14Test {
    @Test fun `duplicate the elements of a list`() {
        assertThat(duplicate("abccd".toList()), equalTo("aabbccccdd".toList()))
    }
}

