/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW07;

/**
 *
 * @author boasm
 */
public interface QueueInterface {

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity
     * restrictions, returning true upon success and throwing an IllegalStateException if no space is currently
     * available.
     *
     * @param letter
     * @return true
     */
    boolean add(Character letter);

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    Character poll();

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    Character peek();
}
