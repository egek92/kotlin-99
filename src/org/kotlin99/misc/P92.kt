package org.kotlin99.misc

import com.natpryce.hamkrest.anyElement
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.common.containsAll
import org.kotlin99.common.permutationsSeq
import org.kotlin99.graphs.Graph
import org.kotlin99.graphs.Graph.TermForm
import org.kotlin99.graphs.Graph.TermForm.Term
import org.kotlin99.graphs.toGraph
import org.kotlin99.graphs.toTermForm
import java.util.*

fun <T> Graph<T, *>.gracefulLabeling(): Sequence<Graph<String, Nothing>> {
    val edgeLabels = 1.rangeTo(edges.size).toHashSet()
    return 1.rangeTo(nodes.size).toList()
        .permutationsSeq()
        .map { nodeLabels -> nodes.keys.zip(nodeLabels).toMap() }
        .filter { mapping ->
            val diffs = edges.mapTo(HashSet()) { edge ->
                Math.abs(mapping[edge.n1.value]!! - mapping[edge.n2.value]!!)
            }
            diffs == edgeLabels
        }
        .map { mapping ->
            toTermForm().run {
                Graph.terms(TermForm(
                    nodes.map { mapping[it]!!.toString() },
                    edges.map { Term<String, Nothing>(mapping[it.n1]!!.toString(), mapping[it.n2]!!.toString()) }
                ))
            }
        }
}


class P92Test {
    @Test fun `basic graceful labeling`() {
        assertThat("[a]".toGraph().gracefulLabeling().first(), equalTo("[1]".toGraph()))

        assertThat("[a-b]".toGraph().gracefulLabeling().toList(), containsAll("[1-2]".toGraph(), "[2-1]".toGraph()))

        assertThat("[a-b, a-c]".toGraph().gracefulLabeling().toList(), containsAll(
            "[1-2, 1-3]".toGraph(), "[1-3, 1-2]".toGraph(),
            "[3-1, 3-2]".toGraph(), "[3-2, 3-1]".toGraph()
        ))
    }

    @Test fun `graceful labeling of examples in readme`() {
        assertThat("[a-d, a-g, a-b, b-c, b-e, e-f]".toGraph().gracefulLabeling().toList(), anyElement(equalTo(
            "[7-2, 7-1, 7-3, 3-6, 3-5, 5-4]".toGraph()
        )))

        // TODO too slow
//        assertThat("[a-i, a-h, a-g, a-b, a-c, c-f, c-d, d-k, c-e, e-g, g-m, g-n, n-p]".toGraph().gracefulLabeling().first(), equalTo(
//                "[7-2, 7-1, 7-3, 3-6, 3-5, 5-4]".toGraph()
//        ))
    }
}