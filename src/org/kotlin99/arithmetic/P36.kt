package org.kotlin99.arithmetic

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P36 (*) Determine the prime factors of a given positive integer (2).

 Construct a list containing prime factors and their multiplicity.

 > 315.primeFactorMultiplicity()
 [(3, 2), (5, 1), (7, 1)]
 */
fun Int.primeFactorMultiplicity(): List<Pair<Int, Int>> =
    primeFactors().fold(emptyList()) { acc, prime ->
        if (acc.isNotEmpty() && acc.last().first == prime)
            acc.dropLast(1)  + Pair(prime, acc.last().second + 1)
        else
            acc + Pair(prime, 1)
    }

class P36Test {
    @Test fun `determine the prime factors of a given positive integer (2)`() {
        assertThat(315.primeFactorMultiplicity(), equalTo(listOf(Pair(3, 2), Pair(5, 1), Pair(7, 1))))
    }
}
