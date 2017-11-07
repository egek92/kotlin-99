package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

// P20 (*) Remove the Kth element from a list.
// Return the list and the removed element in a Tuple. Elements are numbered from 0.
// Example:
//
// > removeAt(1, "abcd".toList())
// ([a, c, d], b)
fun <T> removeAt(n: Int, list: List<T>): Pair<List<T>, T> =
        Pair(list - list[n], list[n])

class P20Test {
    @Test fun `remove the Kth element from a list`() {
        assertThat(removeAt(1, "abcd".toList()), equalTo(Pair(listOf('a', 'c', 'd'), 'b')))
    }
}
