package com.m3tech.kmmcounter

// shared/src/commonMain/kotlin/com/example/shared/Counter.kt
class Counter {
    private var count: Int = 0

    /** increments and returns the new value */
    fun increment(): Int {
        count += 1
        return count
    }

    /** decrement and returns the new value */
    fun decrement(): Int {
        count -= 1
        return count
    }

    /** read-only getter */
    fun getCount(): Int {
        return count
    }

    /** reset */
    fun reset() {
        count = 0
    }
}
