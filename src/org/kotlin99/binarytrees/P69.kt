package org.kotlin99.binarytrees

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.binarytrees.Tree.Node


fun <T> Tree.toDotString(): String = TODO()

/**
 * BNF grammar:
 * ```
 * <dot-string> ::= <value><dot-string><dot-string> | "."
 * ```
 */
fun String.fromDotString(): Tree = TODO()

private fun String.fromDotString(position: Int): Pair<Tree, Int> = TODO()

//class P69Test {
//    @Test fun `conversion to dot-string`() {
//        assertThat("".convertToTree().toDotString(), equalTo("."))
//        assertThat("a".convertToTree().toDotString(), equalTo("a.."))
//        assertThat("a(b(d,e),c(,f(g,)))".convertToTree().toDotString(), equalTo(
//                "abd..e..c.fg..."
//        ))
//    }
//
//    @Test fun `conversion from dot-string`() {
//        assertThat(".".fromDotString(), equalToTree("".convertToTree()))
//        assertThat("a..".fromDotString(), equalToTree("a".convertToTree()))
//        assertThat("abd..e..c.fg...".fromDotString(), equalToTree(
//                "a(b(d,e),c(,f(g,)))".convertToTree()
//        ))
//    }
//}