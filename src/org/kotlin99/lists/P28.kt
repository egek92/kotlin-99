@file:Suppress("UNUSED_DESTRUCTURED_PARAMETER_ENTRY")

package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P28 (*) Sorting a list of lists according to length of sublists.

 a) We suppose that a list contains elements that are lists themselves.
 The objective is to sort elements of the list according to their length. E.g. short lists first, longer lists later, or vice versa.
 Example:
 > lengthSort(listOf("abc".toList(), "de".toList(), "fgh".toList(), "de".toList(), "ijkl".toList(), "mn".toList(), "o".toList()))
 > [[o], [d, e], [d, e], [m, n], [a, b, c], [f, g, h], [i, j, k, l]]

 b) Again, we suppose that a list contains elements that are lists themselves. But this time the objective is to sort
 elements according to their length frequency; i.e. in the default, sorting is done ascendingly, lists with rare lengths are placed first,
 others with a more frequent length come later.

 Example:

 > lengthFreqSort(listOf("abc".toList(), "de".toList(), "fgh".toList(), "de".toList(), "ijkl".toList(), "mn".toList(), "o".toList()))
 [[i, j, k, l], [o], [a, b, c], [f, g, h], [d, e], [d, e], [m, n]]

 Note that in the above example, the first two lists in the result have length 4 and 1 and both lengths appear just once.
 The third and fourth lists have length 3 and there are two list of this length. Finally, the last three lists have length 2. This is the most frequent length.
 */
fun <T> lengthSort(listOfLists: List<List<T>>): List<List<T>> = listOfLists.sortedBy { it.size }

fun <T> lengthFreqSort(listOfLists: List<List<T>>): List<List<T>> =
        listOfLists.groupBy { list -> list.size }
                .toList()
                .sortedBy { (key, value) -> value.size }
                .flatMap { (key, value) -> value }

class P28Test {
    @Test fun `a) sort elements of the list according to their length`() {
        assertThat(
                lengthSort(listOf("abc".toList(), "de".toList(), "fgh".toList(), "de".toList(), "ijkl".toList(), "mn".toList(), "o".toList())),
                equalTo(listOf("o".toList(), "de".toList(), "de".toList(), "mn".toList(), "abc".toList(), "fgh".toList(), "ijkl".toList()))
        )
    }

    @Test fun `b) sort elements according to their length frequency`() {
        assertThat(
                lengthFreqSort(listOf("abc".toList(), "de".toList(), "fgh".toList(), "de".toList(), "ijkl".toList(), "mn".toList(), "o".toList())),
                equalTo(listOf("ijkl".toList(), "o".toList(), "abc".toList(), "fgh".toList(), "de".toList(), "de".toList(), "mn".toList()))
        )
    }
}
