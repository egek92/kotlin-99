package org.kotlin99.binarytrees

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.binarytrees.Tree.Node

//fun <T> Tree.layout2(x: Int = leftmostBranchXShift(), y: Int = 1,
//                     spaces: Spaces = Spaces(this)): Tree = TODO()
//
//data class Spaces(val value: Int) {
//    TODO()
//}

//private fun <T> Tree.leftmostBranchXShift(): Int {
//    TODO()
//    fun leftmostBranchHeight(tree: Tree): Int {
//        TODO()
//    }
//}

private fun Int.pow(n: Int): Int = Math.pow(this.toDouble(), n.toDouble()).toInt()

//class P65Test {
//
//    @Test fun `layout binary tree (2)`() {
//        assertThat(
//                Node("a").layout2().toPrettyString(),
//                equalTo("""
//                | 012
//                |0···
//                |1·a·
//                |2···
//            """.trimMargin()))
//
//        assertThat(
//                Node("a", Node("b")).layout2().toPrettyString(),
//                equalTo("""
//                | 0123
//                |0····
//                |1··a·
//                |2·b··
//                |3····
//            """.trimMargin()))
//
//        assertThat(
//                Node("a", Node("b", Node("c"))).layout2().toPrettyString(),
//                equalTo("""
//                | 012345
//                |0······
//                |1····a·
//                |2··b···
//                |3·c····
//                |4······
//                """.trimMargin()))
//
//        assertThat(
//                Node("a", Node("b", Node("c", Node("d")))).layout2().toPrettyString(),
//                equalTo("""
//                | 0123456789
//                |0··········
//                |1········a·
//                |2····b·····
//                |3··c·······
//                |4·d········
//                |5··········
//                """.trimMargin()))
//
//        assertThat(
//                Node("a", End, Node("b", End, Node("c"))).layout2().toPrettyString(),
//                equalTo("""
//                | 012345
//                |0······
//                |1·a····
//                |2···b··
//                |3····c·
//                |4······
//                """.trimMargin()))
//
//        assertThat(
//                Node("a", Node("b"), Node("c")).layout2().toPrettyString(),
//                equalTo("""
//                | 01234
//                |0·····
//                |1··a··
//                |2·b·c·
//                |3·····
//            """.trimMargin()))
//
//        assertThat(
//                Node("a", Node("b", Node("d"), Node("e")), Node("c", Node("f"), Node("g"))).layout2().toPrettyString(),
//                equalTo("""
//                | 012345678
//                |0·········
//                |1····a····
//                |2··b···c··
//                |3·d·e·f·g·
//                |4·········
//                """.trimMargin()))
//    }
//
//    @Test fun `illustration example`() {
//        assertThat(
//                "nkmcaedgupq".toList().toTree().layout2().toPrettyString(),
//                equalTo("""
//                | 0123456789012345678901234
//                |0·························
//                |1···············n·········
//                |2·······k···············u·
//                |3···c·······m·······p·····
//                |4·a···e···············q···
//                |5····d·g··················
//                |6·························
//                """.trimMargin()))
//    }
//
//}