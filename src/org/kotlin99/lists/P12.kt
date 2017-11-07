package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.common.tail
import java.util.*

/*
P12 (**) Decode a run-length encoded list.

Given a run-length code list generated as specified in problem P10, construct its uncompressed version. Example:

> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
[a, a, a, a, b, c, c, a, a, d, e, e, e, e]
 */
fun <T> decode(list: List<Pair<Int, T>>): List<T> =
        list.fold(emptyList()) { acc, (count, letter) ->
            when (count) {
                1 -> acc + letter
                else -> acc + Collections.nCopies(count, letter)
            }
        }

class P12Test {
    @Test fun `decode a run-length encoded list`() {
        assertThat(decode(listOf(
                Pair(4, 'a'), Pair(1, 'b')
        )), equalTo("aaaab".toList()))
        assertThat(decode(listOf(
                Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')
        )), equalTo("aaaabccaadeeee".toList()))
    }
}
