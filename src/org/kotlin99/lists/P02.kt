package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.common.head
import org.kotlin99.common.tail

/*
 P02 (*) Find the last but one element of a list.

 Example:
 > penultimate(listOf(1, 1, 2, 3, 5, 8))
 5
 */
fun <T> penultimate(list: List<T>): T {
    require(list.size > 1) { "The list has less than 2 elements" }

    return when (list.size) {
        2 -> list.head
        else -> penultimate(list.tail())
    }
}

/*
 Or:
 fun <T> last(list: List<T>) = list.takeLast(2).dropLast(1)
*/

class P02Test {
    @Test fun `find the last but one element of a list`() {
        assertThat(penultimate(listOf(1, 1, 2, 3, 5, 8)), equalTo(5))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `penultimate element in list smaller than 2`() {
        penultimate(listOf(1))
    }
}
