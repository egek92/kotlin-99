package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P08 (**) Eliminate consecutive duplicates of list elements.

 If a list contains repeated elements, they should be replaced with a single copy of the element. The order of the elements should not be changed.
 Example:
 > compress("aaaabccaadeeee".toList())
 [a, b, c, a, d, e]
 */
fun <T> compress(list: List<T>): List<T> =
        list.fold(emptyList()) { result, element ->
            if (result.isEmpty() || result.last() != element)
                result + element
            else result
        }

class P08Test {
    @Test fun `eliminate consecutive duplicates of list elements`() {
        assertThat(compress("".toList()), equalTo("".toList()))
        assertThat(compress("abc".toList()), equalTo("abc".toList()))
        assertThat(compress("aaa".toList()), equalTo("a".toList()))
        assertThat(compress("aaaabccaadeeee".toList()), equalTo("abcade".toList()))
    }
}