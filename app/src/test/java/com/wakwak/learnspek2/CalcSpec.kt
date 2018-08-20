package com.wakwak.learnspek2

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
object CalcSpec : Spek({

    describe("A calculation") {
        val calc by memoized { Calc() }

        it("should return 4") {
            assertEquals(4, calc.addition(2, 2))
        }
    }
})
