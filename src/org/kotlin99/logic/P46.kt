@file:Suppress("NOTHING_TO_INLINE", "unused")

package org.kotlin99.logic

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
P46 (*) Truth tables for logical expressions.

Define functions and_, or_, nand_, nor_, xor_, impl_, and equ_ (for logical equivalence) which return
true or false according to the result of their respective operations.

> true.and_(true)
true
> true.xor_(true)
false
 */
inline fun Boolean.not_() = this.not()
inline fun Boolean.and_(other: Boolean) = (this and other)
inline fun Boolean.or_(other: Boolean) = (this or other)
inline fun Boolean.nand_(other: Boolean) = (this and other).not()
inline fun Boolean.nor_(other: Boolean) = (this or other).not()
inline fun Boolean.xor_(other: Boolean) = (this xor other)
inline fun Boolean.equ_(other: Boolean) = (this xor other).not()
inline fun Boolean.impl_(other: Boolean) = (this or other.not())


/*
 Write a function called printTruthTable which prints the truth table of a given logical expression.

 > printTruthTable{ a, b -> a.and_(a.or_(b.not_())) }
 a	    b	    result
 true	true	true
 true	false	true
 false	true	false
 false	false	false
 */
fun printTruthTable(f: (Boolean, Boolean) -> Boolean) {
    println("a	    b	    result")
    val table = truthTable(f)
    table.forEach { row ->
        println("${row.a}\t${row.b}\t${f(row.a, row.b)}")
    }
}

fun truthTable(f: (Boolean, Boolean) -> Boolean): List<Row> =
    listOf(
            Pair(true,  true),
            Pair(true,  false),
            Pair(false, true),
            Pair(false, false)
    ).map { (a, b) ->
        Row(a, b, f(a, b))
    }


data class Row(val a: Boolean, val b: Boolean, val result: Boolean)

class P46Test {
    @Test fun `logical expressions`() {
        assertThat(true.and_(true), equalTo(true))
        assertThat(true.xor_(true), equalTo(false))
    }

    @Test fun `truth tables for logical expressions`() {
        assertThat(truthTable(Boolean::and_), equalTo(listOf(
                Row(true, true, true),
                Row(true, false, false),
                Row(false, true, false),
                Row(false, false, false)
        )))
        assertThat(truthTable(Boolean::xor_), equalTo(listOf(
                Row(true, true, false),
                Row(true, false, true),
                Row(false, true, true),
                Row(false, false, false)
        )))
        assertThat(truthTable(Boolean::equ_), equalTo(listOf(
                Row(true, true, true),
                Row(true, false, false),
                Row(false, true, false),
                Row(false, false, true)
        )))

        printTruthTable { a, b -> a.and_(a.or_(b.not_())) }
        assertThat(truthTable { a, b -> a.and_(a.or_(b.not_())) }, equalTo(listOf(
                Row(true, true, true),
                Row(true, false, true),
                Row(false, true, false),
                Row(false, false, false)
        )))
    }
}
