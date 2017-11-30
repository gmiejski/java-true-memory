package org.miejski.truememory.memory.heap

import org.springframework.stereotype.Service

@Service
class HeapAllocator {

    val memoryAllocated: ArrayList<ByteArray> = ArrayList()

    fun allocateMemory(mb: Int) {

        val newByteArray = ByteArray(size = mb * 1024 * 1024)
        memoryAllocated.add(newByteArray)
    }

    fun getAllocatedMemory(): Int {
        return memoryAllocated.sumBy { it.size } / 1024 / 1024
    }
}