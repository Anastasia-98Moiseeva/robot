package org.example

import org.example.leg.Leg
import org.example.leg.LegType.LEFT
import org.example.leg.LegType.RIGHT
import org.example.step.LockStep
import org.example.step.QueueStep
import org.example.step.VolatileStep


fun main() {
    val step = LockStep()
    //val step = VolatileStep()
    //val step = QueueStep()
    val n = 10
    Leg(LEFT, step, n).start()
    Leg(RIGHT, step, n).start()
}