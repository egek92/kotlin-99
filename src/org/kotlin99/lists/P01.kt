package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.common.tail

/*
 P01 (*) Find the last element of a list.

 Example:
 > last(listOf(1, 1, 2, 3, 5, 8))
 8
 */
fun <T> last(list: List<T>): T {
    require(list.isNotEmpty()) { "The list is empty" }
    return when (list.size) {
        1 -> list.first()
        else -> last(list.tail())
    }
}

/*
 The easy way:
 fun <T> last(list: List<T>) = list.last()
*/

class P01Test {
    @Test fun `find the last element of a list`() {
        assertThat(last(listOf(1, 1, 2, 3, 5, 8)), equalTo(8))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `last element in empty list`() {
        last(listOf<Int>())
    }
}