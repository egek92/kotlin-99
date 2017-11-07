package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P09 (**) Pack consecutive duplicates of list elements into sublists.

 If a list contains repeated elements, they should be placed in separate sublists.
 Example:

 > pack("aaaabccaadeeee".toList())
 [[a, a, a, a], [b], [c, c], [a, a], [d], [e, e, e, e]]
 */
fun <T> pack(list: List<T>): List<List<T>> =
        list.fold(listOf(emptyList())) { acc, element ->
            if (acc.last().isEmpty() || acc.last().last() == element)
                acc.dropLast(1) + listOf(acc.last() + element)
            else
                acc.plusElement(listOf(element))
        }

class P09Test {
    @Test fun `pack consecutive duplicates of list elements into sublists`() {
        assertThat(pack(emptyList()), equalTo(listOf(emptyList<Char>())))
        assertThat(pack("a".toList()), equalTo(listOf("a".toList())))
        assertThat(pack("aaa".toList()), equalTo(listOf("aaa".toList())))
        assertThat(pack("aaaabcc".toList()), equalTo(listOf(
                "aaaa".toList(), "b".toList(), "cc".toList()
        )))
        assertThat(pack("aaaabccaadeeee".toList()), equalTo(listOf(
                "aaaa".toList(), "b".toList(), "cc".toList(), "aa".toList(), "d".toList(), "eeee".toList()
        )))
    }
}