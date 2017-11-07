package org.kotlin99.lists

import com.natpryce.hamkrest.anyElement
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.common.containsAll
import org.kotlin99.common.tail


/*
 P27 (**) Group the elements of a set into disjoint subsets.

 a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function that generates all the possibilities.
 Example:

 > group3(listOf("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
 [[["Ida", "Hugo", "Gary", "Flip"], ["Evi", "David", "Carla"], ["Beat", "Aldo"]], ...
 //
 b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups. Example:
 //
 > group(listOf(2, 2, 5), listOf("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
 [[["Ida", "Hugo", "Gary", "Flip", "Evi"], ["David", "Carla"], ["Beat", "Aldo"]], ...
 //
 IMPORTANT:
 Note that we do not want permutations of the group members,
 i.e. [[Aldo, Beat], ...]] is the same solution as [[Beat, Aldo], ...].
 However, [[Aldo, Beat], [Carla, David], ...] and [[Carla, David], [Aldo, Beat], ...] are considered to be different solutions.
 You may find more about this combinatorial problem in a good book on discrete mathematics under the term "multinomial coefficients".
 */
fun <T> group3(list: List<T>): List<List<List<T>>> =
        group(listOf(2, 3, 4), list)

fun <T> group(sizes: List<Int>, list: List<T>): List<List<List<T>>> {
    require (sizes.sumBy { it } == list.size) { "sum of sizes must equal the size of the list" }

    if (sizes.isEmpty())
        return listOf(emptyList())
    else
        return combinations(sizes.first(), list).flatMap { initialComb ->
            group(sizes.tail(), list - initialComb)
                    .map { listOf(initialComb) + it }
    }
}


class P27Test {
    @Test fun `a) group the elements into 3 disjoint subgroups of 2, 3 and 4`() {
        val groups = group3(listOf("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
        // groups.forEach { println(it) }
        assertThat(groups, anyElement(containsAll(
                listOf(listOf("Aldo", "Beat"), listOf("Carla", "David", "Evi"), listOf("Flip", "Gary", "Hugo", "Ida"))
        )))
        assertThat(groups.size, equalTo(1260))
    }

    @Test fun `b) group the elements into disjoint subgroups of specified sizes`() {
        val groups = group(listOf(2, 2, 5), listOf("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
        // groups.forEach { println(it) }
        assertThat(groups, anyElement(containsAll(
                listOf(listOf("Aldo", "Beat"), listOf("Carla", "David"), listOf("Evi", "Flip", "Gary", "Hugo", "Ida"))
        )))
        assertThat(groups.size, equalTo(756))

    }
}
