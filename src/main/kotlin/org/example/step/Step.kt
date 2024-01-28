package org.example.step

import org.example.leg.LegType

interface Step {
    fun go(type: LegType)
}