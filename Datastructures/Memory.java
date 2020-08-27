/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW07;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class Memory {

    private static final Logger LOG = LogManager.getLogger(Memory.class);
    private final int memorySize;
    private int memoryCapacity;

    private Memory(int memorySize) {
        this.memorySize = memorySize;
        this.memoryCapacity = memorySize;
    }

    public final static Memory createMemory(int memorySize) {
        if (memorySize <= Short.MAX_VALUE) {
            LOG.info("Memory[Used: 0; Free: " + memorySize + "]");
            return new Memory(memorySize);
        } else {
            throw new IllegalArgumentException("The entered value for memory size should be less than 65'536!");
        }
    }

    public final Allocation malloc(int size) {
        int newCapacity = this.memoryCapacity - size; //&& newCapacity <= this.getMemorySize()
        if (size <= this.getMemorySize() && newCapacity > 0) {
            Allocation block = new Allocation(size, memorySize, memoryCapacity);
            this.memoryCapacity -= size;
            return block;
        } else if (size > this.getMemorySize()) {
            throw new IllegalArgumentException("The entered allocation value is greater than the size of memory: " + this.getMemorySize() + "!");
        } else {
            throw new IllegalArgumentException("The entered allocation value is greater than the memory capacity: " + this.getMemoryCapacity() + "!");
        }
    }

    public final int getMemorySize() {
        return memorySize;
    }

    public int getMemoryCapacity() {
        return memoryCapacity;
    }
}
