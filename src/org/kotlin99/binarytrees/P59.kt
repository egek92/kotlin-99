package org.kotlin99.binarytrees

import com.natpryce.hamkrest.*
import com.natpryce.hamkrest.assertion.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test
import org.kotlin99.binarytrees.Tree.*
import org.kotlin99.common.*

fun <T> heightBalancedTrees(height: Int, value: T): List<Tree> = TODO()

fun <T> Tree.height(): Int = TODO()

fun <T> Tree.nodes(): List<Node<T>> = TODO()

//class P59Test {
//    @Test fun `construct all height-balanced binary trees`() {
//        assertThat(heightBalancedTrees(1, "x"), containsAll(nodeList(Node("x"))))
//        assertThat(heightBalancedTrees(2, "x"), containsAll(nodeList(
//            Node("x", Node("x"), Node("x")),
//            Node("x", End, Node("x")),
//            Node("x", Node("x"), End)
//        )))
//
//        assertThat(heightBalancedTrees(3, "x"), containsElements<Tree>(
//            equalTo(
//                Node("x",
//                     Node("x", End, Node("x")),
//                     Node("x", Node("x"), End))),
//            equalTo(
//                Node("x",
//                     Node("x", Node("x"), End),
//                     Node("x", End, Node("x"))))
//        ))
//
//        heightBalancedTrees(3, "x").flatMap{ it.nodes() }.forEach { node ->
//            assertTrue(node.left.height() - node.right.height() <= 1)
//        }
//    }
//
//    private fun <T> containsElements(vararg matchers: Matcher<T>) : Matcher<Iterable<T>> {
//        return matchers.tail().fold(anyElement(matchers.first())){ result: Matcher<Iterable<T>>, matcher ->
//            result.and(anyElement(matcher))
//        }
//    }
//}
//