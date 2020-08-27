/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW07;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class Allocation implements Comparable<Allocation> {

    private static final Logger LOG = LogManager.getLogger(Allocation.class);
    private final int size;
    private final int startAddress;

    public Allocation(int size, int memorySize, int memoryCapacity) {
        this.size = size;
        this.startAddress = memorySize - memoryCapacity;
        LOG.info("Allocation[Address: " + this.getStartAddress() + "; Size: " + this.getSize() + "]");
        LOG.info("Memory[Used: " + (this.startAddress + size) + "; Free: " + memorySize + "]");
    }

    public final int getSize() {
        return size;
    }

    public final int getStartAddress() {
        return startAddress;
    }

    @Override
    public int compareTo(Allocation other) {
        return Integer.compare(this.getStartAddress(), other.getStartAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getSize(), this.getStartAddress());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Allocation)) {
            return false;
        }
        final Allocation other = (Allocation) obj;
        return (Objects.equals(this.getSize(), other.getSize()) && Objects.equals(this.getStartAddress(), other.getStartAddress()));
    }

    @Override
    public String toString() {
        return "Allocation{" + "size=" + size + ", startAddress=" + startAddress + '}';
    }

}
