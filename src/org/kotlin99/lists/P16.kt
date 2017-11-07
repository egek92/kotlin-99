package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P16 (**) Drop every Nth element from a list.
 Example:
 > drop(3, "abcdefghijk".toList())
 [a, b, d, e, g, h, j, k]
 */
fun <T> drop(n: Int, list: List<T>): List<T> =
        list.foldIndexed(emptyList()) { i, acc, el ->
            if ((i + 1) % n == 0) acc
            else acc + el
        }

class P16Test {
    @Test fun `drop every Nth element from a list`() {
        assertThat(drop(3, "abcdefghijk".toList()), equalTo("abdeghjk".toList()))
    }
}
