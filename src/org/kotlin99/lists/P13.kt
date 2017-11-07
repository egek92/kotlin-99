package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P13 (**) Run-length encoding of a list (direct solution).

 Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly. Example:

 > encodeDirect("aaaabccaadeeee".toList())
 [(4, a), (1, b), (2, c), (2, a), (1, d), (4, e)]
 */
fun <T> encodeDirect(list: List<T>): List<Pair<Int, T>> =
        list.fold(emptyList()) { acc, element ->
            if (acc.isNotEmpty() && element == acc.last().second)
                acc.dropLast(1) + Pair(acc.last().first + 1, element)
            else
                acc + Pair(1, element)
        }

class P13Test {
    @Test fun `run-length encoding of a list (direct solution)`() {
        assertThat(encodeDirect("aaaabccaadeeee".toList()), equalTo(listOf(
                Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')
        )))
    }
}
