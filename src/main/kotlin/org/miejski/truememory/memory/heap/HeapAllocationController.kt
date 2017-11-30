package org.miejski.truememory.memory.heap

import org.miejski.truememory.memory.heap.dto.HeapAllocationDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HeapAllocationController @Autowired constructor(val heapAllocator: HeapAllocator) {

    @RequestMapping(path = arrayOf("/memory/heap/allocate/{mb}"))
    fun allocateMemory(@PathVariable("mb") mb: Int) {
        heapAllocator.allocateMemory(mb)
    }

    @RequestMapping(path = arrayOf("/memory/heap"))
    fun getAllocatedMemory(): ResponseEntity<HeapAllocationDto> {
        val mbs = heapAllocator.getAllocatedMemory()
        return ResponseEntity.ok(HeapAllocationDto(mbs))
    }
}