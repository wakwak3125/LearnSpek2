package com.wakwak.learnspek2

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CalcUnitTest {

    private lateinit var calc: Calc

    @Before
    fun setUp() {
        calc = Calc()
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, calc.addition(2, 2))
    }
}
