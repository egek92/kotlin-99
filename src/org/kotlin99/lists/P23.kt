package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import java.util.*

// P23 (*) Extract a given number of randomly selected elements from a list.
//
// Make sure there is a way to produce deterministic results.
//
// Example:
//
// > randomSelect(3, "abcdefgh".toList())
// [c, h, f]
fun <T> randomSelect(n: Int, list: List<T>, random: Random = Random()): List<T> {
    if (n == 0) {
        return emptyList()
    } else {
        val selected = list[random.nextInt(list.size)]
        return randomSelect(n - 1, list - selected, random) + listOf(selected)
    }
}



class P23Test {
    @Test fun `extract a given number of randomly selected elements from a list`() {
        assertThat(randomSelect(3, "abcdefgh".toList(), Random(123)), equalTo("chf".toList()))
    }
}

