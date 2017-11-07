package org.kotlin99.logic

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.common.tail

// Functions below cannot be "inline" because there are recursive.

/*
 P48 (*) Truth tables for logical expressions (3).

 Generalize problem 46 in such a way that the logical expression may contain any number of logical variables. Example:

 > true.xor_(true, false, true)
 true
 */
fun Boolean.and_(vararg others: Boolean): Boolean =
        if (others.isEmpty()) this
        else this.and_(others.first().and_(*(others.tail())))

fun Boolean.or_(vararg others: Boolean): Boolean =
        if (others.isEmpty()) this
        else this.or_(others.first().or_(*(others.tail())))

fun Boolean.xor_(vararg others: Boolean): Boolean =
        if (others.isEmpty()) this
        else this.xor_(others.first().xor_(*(others.tail())))

private fun BooleanArray.tail() = drop(1).toBooleanArray()

class P48Test {
    @Test fun `logical expressions`() {
        assertThat(true.and_(true, false, true), equalTo(false))
        assertThat(true.or_(true, false, false), equalTo(true))
        assertThat(true.xor_(true, false, true), equalTo(true))
    }
}