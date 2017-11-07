package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.common.tail

/*
 P04 (*) Find the number of elements of a list.

 Example:
 > length(listOf(1, 1, 2, 3, 5, 8))
 6
 */
fun <T> length(list: List<T>): Int =
        when {
            list.isEmpty() -> 0
            else -> 1 + length(list.tail())
        }

class P04Test {
    @Test fun `find the number of elements of a list`() {
        assertThat(length(emptyList<Int>()), equalTo(0))
        assertThat(length(listOf(1, 1, 2, 3, 5, 8)), equalTo(6))
    }
}