package org.example.step

import org.example.leg.LegType
import org.example.leg.next

class VolatileStep: Step {
    @Volatile
    private var nextLegType = LegType.RIGHT

    override fun go(type: LegType) {
        while (type != nextLegType) {
            Thread.yield()
        }
        println(type.name)
        nextLegType = nextLegType.next()
    }
}