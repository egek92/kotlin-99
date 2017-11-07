package org.kotlin99.binarytrees

import com.natpryce.hamkrest.assertion.assertThat
import org.junit.Test
import org.kotlin99.binarytrees.Tree.Node
import org.kotlin99.common.containsAll

/*
 P55 (*) Construct completely balanced binary trees.

 In a completely balanced binary tree, the following property holds for every node.
 The number of nodes in its left subtree and the number of nodes in its right subtree are almost equal,
 which means their difference is not greater than one. Define an object named Tree. Write a function balancedTrees to
 construct completely balanced binary trees for a given number of nodes. The function should generate all solutions.
 The function should take as parameters the number of nodes and a single value to put in all of them.
 */
fun <T> balancedTrees(treeSize: Int, value: T): List<Tree> {
    TODO()
}

class P55Test {
//    @Test fun `construct all balanced trees`() {
//        assertThat(balancedTrees(1, "x"), containsAll(nodeList(Node("x"))))
//        assertThat(balancedTrees(2, "x"), containsAll(nodeList(
//                Node("x", End, Node("x")),
//                Node("x", Node("x"), End)
//        )))
//        assertThat(balancedTrees(3, "x"), containsAll(nodeList(
//                Node("x", Node("x"), Node("x"))
//        )))
//        assertThat(balancedTrees(4, "x"), containsAll(nodeList(
//                Node("x", Node("x"), Node("x", End, Node("x"))),
//                Node("x", Node("x", End, Node("x")), Node("x")),
//                Node("x", Node("x"), Node("x", Node("x"), End)),
//                Node("x", Node("x", Node("x"), End), Node("x"))
//        )))
//    }
//
//    companion object {
//        fun nodeList(vararg nodes: Node<String>): Iterable<Tree> = nodes.asList()
//    }
}