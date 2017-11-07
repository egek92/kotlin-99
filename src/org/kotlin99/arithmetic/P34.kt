package org.kotlin99.arithmetic

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

/*
 P34 (*) Calculate Euler's totient function phi(m).

 Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
 */
fun Int.totient() = (1..this).count { this.isCoprimeTo(it) }

class P34Test {
    @Test fun `calculate Euler's totient function`() {
        assertThat(10.totient(), equalTo(4))
        assertThat(10090.totient(), equalTo(4032))
    }
}
