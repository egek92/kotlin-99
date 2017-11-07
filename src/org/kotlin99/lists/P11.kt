package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P11 (*) Modified run-length encoding.

 Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result
 list. Only elements with duplicates are transferred as (N, E) terms. Example:

 > encodeModified("aaaabccaadeeee".toList())
 [(4, a), b, (2, c), (2, a), d, (4, e)]
 */
@Suppress("IMPLICIT_CAST_TO_ANY")
fun <T : Any> encodeModifies(list: List<T>): List<Any> =
        pack(list).map {
            when (it.count()) {
                1 -> it.first()
                else -> Pair(it.count(), it.first())
            }
        }


class P11Test {
    @Test fun `modified run-length encoding`() {
        assertThat(encodeModifies("aaaabccaadeeee".toList()), equalTo(listOf<Any>(
                Pair(4, 'a'), 'b', Pair(2, 'c'), Pair(2, 'a'), 'd', Pair(4, 'e')
        )))
    }
}