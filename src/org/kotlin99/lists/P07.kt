package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P07 (**) Flatten a nested list structure.

 Example:

 > flatten(listOf(listOf(1, 1), 2, listOf(3, listOf(5, 8))))
 [1, 1, 2, 3, 5, 8]
 */
fun flatten(list: List<Any?>): List<Any> =
        list.flatMap {
            when (it) {
                is List<*> -> flatten(it)
                else -> listOf(it).filterNotNull()
            }
        }


class P07Test {
    @Test
    fun `flatten a nested list structure`() {
        assertThat(flatten(listOf(1)), equalTo(listOf<Any>(1)))
        assertThat(flatten(listOf(listOf(1, 2))), equalTo(listOf<Any>(1, 2)))
        assertThat(flatten(listOf(1, listOf(2))), equalTo(listOf<Any>(1, 2)))
        assertThat(
                flatten(listOf(listOf(1, 1), 2, listOf(3, listOf(5, 8)))),
                equalTo(listOf<Any>(1, 1, 2, 3, 5, 8))
        )
    }
}