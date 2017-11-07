package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import java.util.NoSuchElementException

/*
 P03 (*) Find the Nth element of a list.

 By convention, the first element in the list is element 0.
 Example:
 > nth(2, listOf(1, 1, 2, 3, 5, 8))
 2
 */
tailrec fun <T> nth(n: Int, list: List<T>): T {
    if (n == 0)
        return list.first()

    return nth(n - 1, list.drop(1))
}

/*
 or:
 fun <T> nth(n: Int, list: List<T>): T = list[n]
 */

class P03Test {
    @Test fun `find the Nth element of a list`() {
        assertThat(nth(2, listOf(1, 1, 2, 3, 5, 8)), equalTo(2))
    }

    @Test(expected = NoSuchElementException::class)
    fun `Nth element outside of list size`() {
        nth(100, listOf(1, 1, 2, 3, 5, 8))
    }
}