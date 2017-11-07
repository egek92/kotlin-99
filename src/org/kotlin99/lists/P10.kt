package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P10 (*) Run-length encoding of a list.

 Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
 Example:
 > encode("aaaabccaadeeee".toList())
 [(4, a), (1, b), (2, c), (2, a), (1, d), (4, e)]
 */
fun <T> encode(list: List<T>): List<Pair<Int, T>> =
        pack(list).map { (it.size to it.first()) }

class P10Test {
    @Test
    fun `run-length encoding of a list`() {
        assertThat(encode("aaaabccaadeeee".toList()), equalTo(listOf(
                Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')
        )))
    }
}