package com.wakwak.learnspek2

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import kotlin.test.assertEquals

object CalcFeature : Spek({
    Feature("Addition") {
        val calc = Calc()
        val c by memoized { Calc() }
        var result = 0

        Scenario("Simple calculation") {

            When("Add 2 + 2") {
                result = calc.addition(2, 2)
            }

            Then("it should be 4") {
                assertEquals(4, result)
            }
        }

        Scenario("Simple calculation") {
            When("Add -1 + -1") {
                result = calc.addition(-1, -1)
            }

            Then("it should be -2") {
                assertEquals(-2, result)
            }
        }
    }
})
