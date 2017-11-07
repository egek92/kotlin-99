package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.common.containsAll
import org.kotlin99.common.tail

// P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list.
//
// In how many ways can a committee of 3 be chosen from a group of 12 people? There are C(12,3) = 220 possibilities,
// where C(N,K) denotes binomial coefficient. For pure mathematicians, this result may be great. But we want to really
// generate all the possibilities.
//
// Example:
// > combinations(3, "abcde".toList())
// [[c, b, a], [d, b, a], [e, b, a], [d, c, a], [e, c, a], [e, d, a], [d, c, b], [e, c, b], [e, d, b], [e, d, c]]
fun <T> combinations(k: Int, list: List<T>): List<List<T>> =
        if (list.isEmpty())
            listOf(emptyList())
        else
            list.foldIndexed(listOf(emptyList<T>())) { index, acc, _ ->
                acc + combinations(k - 1, list.drop(index + 1))
                        .map { listOf(list[index]) + it }
            }.filter { it.size == k }


class P26Test {
    @Test fun `generate the combinations of K distinct objects chosen from the N elements of a list`() {
        assertThat(combinations(0, "abc".toList()), equalTo(listOf(emptyList())))
        assertThat(combinations(1, "abc".toList()), containsAll(listOf(
                "a".toList(), "b".toList(), "c".toList()
        )))
        assertThat(combinations(2, "abc".toList()), containsAll(listOf(
                "cb".toList(), "ab".toList(), "ca".toList()
        )))
        assertThat(combinations(3, "abc".toList()), containsAll(listOf(
                "cba".toList()
        )))

        assertThat(combinations(3, "abcde".toList()), containsAll(listOf(
                "cba".toList(), "dba".toList(), "eba".toList(),
                "dca".toList(), "eca".toList(), "eda".toList(),
                "dcb".toList(), "ecb".toList(), "edb".toList(),
                "edc".toList()
        )))

        /* Might as well have the solution generate combinations in list order :) */
        assertThat(combinations(1, "abc".toList()), equalTo(listOf(
                "a".toList(), "b".toList(), "c".toList()
        )))
        assertThat(combinations(2, "abc".toList()), equalTo(listOf(
                "ab".toList(), "ac".toList(), "bc".toList()
        )))
        assertThat(combinations(3, "abc".toList()), equalTo(listOf(
                "abc".toList()
        )))

        assertThat(combinations(3, "abcde".toList()), equalTo(listOf(
                "abc".toList(), "abd".toList(), "abe".toList(),
                "acd".toList(), "ace".toList(), "ade".toList(),
                "bcd".toList(), "bce".toList(), "bde".toList(),
                "cde".toList()
        )))
        assertThat(combinations(3, "abcdefghijkl".toList()).size, equalTo(220))
        assertThat(combinations(8, "abcdefghijklmnopqrst".toList()).size, equalTo(125970))

    }
}
