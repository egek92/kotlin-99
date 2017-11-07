package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import java.util.*

// P25 (*) Generate a random permutation of the elements of a list.
//
// Make sure there is a way to produce deterministic results. Hint: Use the solution of problem P23. Example:
//
// > randomPermute("abcdef".toList())
// [d, b, e, f, a, c]
fun <T> randomPermute(list: List<T>, random: Random = Random()): List<T> =
        randomSelect(list.size, list, random)

class P25Test {
    @Test fun `generate a random permutation of the elements of a list`() {
        assertThat(randomPermute("abcdef".toList(), Random(123)), equalTo("dbefac".toList()))
    }
}
