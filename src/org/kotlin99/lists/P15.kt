package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import java.util.*

/*
 P15(**) Duplicate the elements of a list a given number of times.

 Example:

 > duplicateN(3, "abccd".toList())
 [a, a, a, b, b, b, c, c, c, c, c, c, d, d, d]
 */
fun <T> duplicateN(n: Int, list: List<T>): List<T> =
        list.fold(emptyList()) { acc, element ->
            acc + Collections.nCopies(n, element)
        }

class P15Test {
    @Test fun `duplicate the elements of a list a given number of times`() {
        assertThat(duplicateN(3, "abccd".toList()), equalTo("aaabbbccccccddd".toList()))
    }
}

