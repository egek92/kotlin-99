package org.kotlin99.lists

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.common.dropFirstAndLast

/*
 P06 (*) Find out whether a list is a palindrome.

 Example:
 > isPalindrome(listOf(1, 2, 3, 2, 1))
 true
 */
tailrec fun <T> isPalindrome(list: List<T>): Boolean {
    if (list.size <= 1) {
        return true
    } else if (list.first() != list.last()) {
        return false
    }

    return isPalindrome(list.dropFirstAndLast())
}

/*
 or:
 list == list.reversed()
 */

@Suppress("unused")
fun <T> isPalindrome_(list: List<T>) = list == list.asReversed()

class P06Test {
    @Test fun `find out whether a list is a palindrome`() {
        assertThat(isPalindrome(emptyList<Int>()), equalTo(true))
        assertThat(isPalindrome(listOf(1)), equalTo(true))
        assertThat(isPalindrome(listOf(1, 2)), equalTo(false))
        assertThat(isPalindrome(listOf(1, 2, 1)), equalTo(true))
        assertThat(isPalindrome(listOf(1, 2, 2, 1)), equalTo(true))
    }
}