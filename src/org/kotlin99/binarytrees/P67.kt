package org.kotlin99.binarytrees

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.binarytrees.Tree.Node

fun <T> Tree.convertToString(): String = TODO()

//fun String.convertToTree(): Tree {
//    fun String.drop(prefix: String): String = TODO()
//
//    fun String.parse(): Pair<Tree, Int> {
//        TODO()
//    }
//
//}

//class P67Test {
//    @Test fun `conversion to string`() {
//        assertThat(End.convertToString(), equalTo(""))
//        assertThat(Node("a").convertToString(), equalTo("a"))
//        assertThat(Node("a", Node("b"), Node("c")).convertToString(), equalTo("a(b,c)"))
//        assertThat(Node("a", Node("b", Node("d"), Node("e")), Node("c", End, Node("f", Node("g"), End))).convertToString(), equalTo(
//                "a(b(d,e),c(,f(g,)))"
//        ))
//    }
//
//    @Test fun `conversion from string`() {
//        assertThat("".convertToTree(), equalToTree<String>(End))
//        assertThat("a".convertToTree(), equalToTree(Node("a")))
//        assertThat("a(b,c)".convertToTree(), equalToTree(Node("a", Node("b"), Node("c"))))
//        assertThat("a(b(d,e),c(,f(g,)))".convertToTree(), equalToTree(
//                Node("a", Node("b", Node("d"), Node("e")), Node("c", End, Node("f", Node("g"), End)))
//        ))
//    }
//}