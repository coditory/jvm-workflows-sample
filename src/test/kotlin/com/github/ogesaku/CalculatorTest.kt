package com.github.ogesaku

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({
    test("2 + 2 == 4") {
        Calculator.add(2, 2) shouldBe 4
    }
})
