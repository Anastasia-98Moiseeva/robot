package org.example.step

import org.example.leg.LegType
import org.example.leg.next
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class QueueStep: Step {
    private val next: BlockingQueue<LegType> = LinkedBlockingQueue<LegType>(1).also { it.put(LegType.RIGHT) }

    override fun go(type: LegType) {
        while (next.peek() != type) {
            Thread.yield()
        }
        next.take()
        println(type.name)
        next.put(type.next())
    }
}