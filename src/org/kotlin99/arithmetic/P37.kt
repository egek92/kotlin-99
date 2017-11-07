package org.kotlin99.arithmetic

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.kotlin99.common.tail


/*
 P37 (*) Calculate Euler's totient function phi(m) (improved).

 See problem P34 for the definition of Euler's totient function.
 If the list of the prime factors of a number m is known in the form of problem P36, then the function phi(m) can be
 efficiently calculated as follows: Let [[p1, m1], [p2, m2], [p3, m3], ...] be the list of prime factors
 (and their multiplicities) of a given number m.
 Then phi(m) can be calculated with the following formula: phi(m) = (p1-1)*p1^(m1-1) * (p2-1)*p2^(m2-1) * (p3-1)*p3^(m3-1) * ...
 */
fun Int.totient2(): Int =
    primeFactorMultiplicity().fold(1) { acc, (p, m) ->
        acc * ((p - 1) * Math.pow(p.toDouble(), (m - 1).toDouble())).toInt()
    }

class P37Test {
    @Test fun `calculate Euler's totient function (improved)`() {
        assertThat(10.totient(), equalTo(4))
        assertThat(10090.totient(), equalTo(4032))
        assertThat(10.totient2(), equalTo(4))
        assertThat(10090.totient2(), equalTo(4032))
    }
}
