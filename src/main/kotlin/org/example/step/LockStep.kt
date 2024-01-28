package org.example.step

import org.example.leg.LegType
import org.example.leg.LegType.RIGHT
import org.example.leg.next
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class LockStep: Step {
    private val lock = ReentrantLock()
    private val condition = lock.newCondition()
    private var nextLegType = RIGHT

    override fun go(type: LegType) {
        lock.withLock {
            while (nextLegType != type) {
                condition.await()
            }
            println(type.name)
            nextLegType = nextLegType.next()
            condition.signalAll()
        }
    }
}