package org.example.leg

import org.example.step.Step

class Leg (
    private val legType: LegType,
    private val step: Step,
    private val n: Int,
): Thread() {
    override fun run() {
        for (i in 1 .. n) step.go(legType)
    }
}