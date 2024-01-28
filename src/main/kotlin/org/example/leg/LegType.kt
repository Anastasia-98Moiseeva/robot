package org.example.leg

import org.example.leg.LegType.LEFT
import org.example.leg.LegType.RIGHT

enum class LegType {
    RIGHT, LEFT
}

fun LegType.next() =
    when (this) {
        RIGHT -> LEFT
        else -> RIGHT
    }
