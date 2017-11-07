package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P19 (**) Rotate a list N places to the left.
 > rotate(3, "abcdefghijk".toList())
 [d, e, f, g, h, i, j, k, a, b, c]

 > rotate(-2, "abcdefghijk".toList())
 [j, k, a, b, c, d, e, f, g, h, i]
 */
fun <T> rotate(n: Int, list: List<T>): List<T> =
    when {
        n > 0 -> list.drop(n) + list.take(n)
        n < 0 -> list.takeLast(-n) + list.dropLast(-n)
        else  -> list
    }

class P19Test {
    @Test fun `rotate a list N places to the left`() {
        assertThat(rotate(0, "abcdefghijk".toList()), equalTo("abcdefghijk".toList()))
        assertThat(rotate(3, "abcdefghijk".toList()), equalTo("defghijkabc".toList()))
        assertThat(rotate(-2, "abcdefghijk".toList()), equalTo("jkabcdefghi".toList()))
    }
}
