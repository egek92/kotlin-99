package org.kotlin99.binarytrees

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.binarytrees.Tree.*

fun <T> Tree.isSymmetric(): Boolean = TODO()

fun Tree.isMirrorOf(that: Tree): Boolean = TODO()

class P56Test {
//    @Test fun `tree is mirror of another tree`() {
//        assertThat(Node("x").isMirrorOf(Node("x")), equalTo(true))
//        assertThat(Node("x").isMirrorOf(Node("x", Node("x"))), equalTo(false))
//        assertThat(Node("x", End, Node("x")).isMirrorOf(Node("x", End, Node("x"))), equalTo(false))
//        assertThat(Node("x", End, Node("x")).isMirrorOf(Node("x", Node("x"))), equalTo(true))
//    }
//
//    @Test fun `tree is symmetric`() {
//        assertThat(Node("x").isSymmetric(), equalTo(true))
//        assertThat(Node("x", Node("x")).isSymmetric(), equalTo(false))
//        assertThat(Node("x", End, Node("x")).isSymmetric(), equalTo(false))
//        assertThat(Node("x", Node("x"), Node("x")).isSymmetric(), equalTo(true))
//        assertThat(Node("x", Node("x", End, Node("x")), Node("x", Node("x"))).isSymmetric(), equalTo(true))
//    }
}