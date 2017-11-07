package org.kotlin99.logic

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import java.util.*

/*
 P50 (**) Huffman code.

 If you are not familiar with Huffman coding, consult internet (or a good book).

 a) Given characters with their frequencies, e.g. {a=25, b=21, c=18, d=14, e=9, f=7, g=6}.
 Our objective is to construct a Map, where key is character and value is the Huffman code for it.
 */
const val INTERNAL_NODE_SYMBOL: Char = '*'

data class HuffmanTreeNode(
        val frequency: Int,
        val symbol: Char,
        val left: HuffmanTreeNode? = null,
        val right: HuffmanTreeNode? = null
) : Comparable<HuffmanTreeNode> {

    val isLeaf = left == null && right == null

    override fun compareTo(other: HuffmanTreeNode): Int {
        return this.frequency.compareTo(other.frequency)
    }

    override fun toString(): String {
        return "(freq: $frequency, symbol: $symbol, L: $left, R: $right)"
    }
}

data class HuffmanEncoding(val tree: HuffmanTreeNode, val codeByChar: Map<Char, String>)

fun String.encode(encoding: HuffmanEncoding): String =
        this.map { char ->
            encoding.codeByChar[char]
        }.joinToString("")

private fun String.createEncoding(): HuffmanEncoding =
        createEncoding(this.charFrequencies())

private fun String.charFrequencies(): Map<Char, Int> = this.groupingBy { it }.eachCount()

fun String.decode(encoding: HuffmanEncoding): String {
    val codes = encoding.codeByChar.values
    val codeToSymbolMap = encoding.codeByChar.map { (symbol, code) ->
        code to symbol
    }.toMap()

    var remainingString = this

    return buildString {
        while (remainingString.isNotBlank()) {
            val code = codes.first { remainingString.startsWith(it) }
            val symbol = codeToSymbolMap[code]
            append(symbol)
            remainingString = remainingString.drop(code.length)
        }
    }
}

/**
 * Create the Huffman Tree
 */
fun createEncoding(frequencyByChar: Map<Char, Int>): HuffmanEncoding {
    val minHeap: PriorityQueue<HuffmanTreeNode> = initializeMinHeap(frequencyByChar)
    val huffmanTree = buildHuffmanTree(minHeap)

    val codes = generateCodes(huffmanTree)
    return HuffmanEncoding(huffmanTree, codes)
}

/**
 * Create Min-Heap of HuffmanTreeNodes (with all leaf nodes)
 */
private fun initializeMinHeap(frequencies: Map<Char, Int>): PriorityQueue<HuffmanTreeNode> {
    val leafNodes = createLeafNodesFromFrequencies(frequencies)
    return PriorityQueue(leafNodes)
}

private fun createLeafNodesFromFrequencies(frequencies: Map<Char, Int>): List<HuffmanTreeNode> =
        frequencies.entries.fold(emptyList()) { acc, (symbol, freq) ->
            acc + HuffmanTreeNode(freq, symbol)
        }

private fun buildHuffmanTree(minHeap: PriorityQueue<HuffmanTreeNode>): HuffmanTreeNode {
    while (minHeap.size > 1) {
        val subtreeRoot = createSubtree(removeTwoLeastFrequent(minHeap))
        minHeap.add(subtreeRoot)
    }
    return minHeap.peek()
}

private fun createSubtree(twoLeastFrequent: Pair<HuffmanTreeNode, HuffmanTreeNode>): HuffmanTreeNode =
        HuffmanTreeNode(
                twoLeastFrequent.toList().sumBy { it.frequency },
                INTERNAL_NODE_SYMBOL,
                twoLeastFrequent.first,
                twoLeastFrequent.second
        )

private fun removeTwoLeastFrequent(minHeap: PriorityQueue<HuffmanTreeNode>): Pair<HuffmanTreeNode, HuffmanTreeNode> =
        (minHeap.poll() to minHeap.poll())

/**
 * Traverse tree to build a map of each symbol's code.
 */
private fun generateCodes(huffmanTree: HuffmanTreeNode): Map<Char, String> =
        generateCodes(huffmanTree, "", mutableMapOf())

private fun generateCodes(node: HuffmanTreeNode?, pathToNode: String, codes: MutableMap<Char, String>): Map<Char, String> {
    node?.let {
        if (node.isLeaf)
            codes[node.symbol] = pathToNode

        node.left?.let { generateCodes(node.left, pathToNode + "0", codes) }
        node.right?.let { generateCodes(node.right, pathToNode + "1", codes) }
    }

    return codes
}

class P50Test {
    @Test
    fun `letter to code mapping`() {
        assertThat(
                createEncoding(linkedMapOf(Pair('a', 25), Pair('b', 21), Pair('c', 18), Pair('d', 14),
                        Pair('e', 9), Pair('f', 7), Pair('g', 6))).codeByChar,
                equalTo<Map<Char, String>>(linkedMapOf(
                        Pair('a', "10"), Pair('b', "00"), Pair('c', "111"), Pair('d', "110"), Pair('e', "010"), Pair('f', "0111"), Pair('g', "0110")
                ))
        )
    }

    @Test
    fun `another encoding test`() {
        assertThat(
                createEncoding(linkedMapOf(
                        Pair('a', 5),
                        Pair('b', 7),
                        Pair('c', 10),
                        Pair('d', 15),
                        Pair('e', 20),
                        Pair('f', 45)
                )).codeByChar,
                equalTo<Map<Char, String>>(linkedMapOf(
                        Pair('a', "1010"),
                        Pair('b', "1011"),
                        Pair('c', "100"),
                        Pair('d', "110"),
                        Pair('e', "111"),
                        Pair('f', "0")
                ))
        )
    }

    @Test
    fun `encoding and decoding a string`() {
        val string = "this is a sentence"
        val encoding = string.createEncoding()

        val encodedString = string.encode(encoding)
        // Equivalent Huffman Codes.
        /* assertThat(encodedString, equalTo("00110000101011100101011101001110101111011001111011000111")) */
        assertThat(encodedString, equalTo("01010110100001101000011010101100011101101011101110111111"))

        val decodedString = encodedString.decode(encoding)
        assertThat(decodedString, equalTo("this is a sentence"))
    }
}