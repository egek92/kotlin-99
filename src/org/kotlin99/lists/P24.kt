package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import java.util.*

// P24 (*) Lotto: Draw N different random numbers from the set 1..M.
//
// Make sure there is a way to produce deterministic results. Example:
//
// > lotto(6, 49)
// [32, 28, 8]
fun lotto(n: Int, k: Int, random: Random = Random()): List<Int> =
        randomSelect(n, (1..k).toList(), random)

class P24Test {
    @Test fun `draw N different random numbers from the set 1 to M`() {
        assertThat(lotto(1, 49, Random(123)), equalTo(listOf(8)))
        assertThat(lotto(2, 49, Random(123)), equalTo(listOf(28, 8)))
        assertThat(lotto(3, 49, Random(123)), equalTo(listOf(32, 28, 8)))
        assertThat(lotto(6, 49, Random(123)), equalTo(listOf(23, 34, 39, 32, 28, 8)))
    }
}
