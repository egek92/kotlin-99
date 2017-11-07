package org.kotlin99.binarytrees

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.binarytrees.Tree.*

/**
  Original implementation: https://github.com/dkandalov/kotlin-99/blob/master/src/org/kotlin99/binarytrees/Tree.kt
  Mostly the same except using sealed classes, [EmptyNode] object instead of End
 */
sealed class Tree {
    class Node<out T>(val value: T, val left: Tree? = EmptyNode, val right: Tree? = EmptyNode) : Tree() {
        override fun toString(): String {
            val children = if (left == EmptyNode && right == EmptyNode) "" else " $left $right"
            return "T($value$children)"
        }
    }
    object EmptyNode : Tree() {
        override fun toString() = "."
    }
}

class TreeTest {
    @Test
    fun `tree construction and string conversion`() {
        val node =
            Node('a',
                Node('b',
                    Node('d'),
                    Node('e')),
                Node('c', EmptyNode,
                    Node('f', Node('g'),
                            EmptyNode)))
        assertThat(node.toString(), equalTo("T(a T(b T(d) T(e)) T(c . T(f T(g) .)))"))
    }
}