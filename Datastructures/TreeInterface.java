/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW07;

/**
 * @author boasm
 * @param <E>
 */
public interface TreeInterface<E> {

    /**
     * Adds the specified element to this set if it is not already present. More formally, adds the specified element e
     * to this set if the set contains no element e2 such that Objects. equals(e, e2). If this set already contains the
     * element, the call leaves the set unchanged and returns false.
     *
     * @param object
     * @return true if this set did not already contain the specified element
     */
    boolean add(E object);

    /**
     * Returns true if this set contains the specified element. More formally, returns true if and only if this set
     * contains an element e such that Objects.equals(o, e).
     *
     * @param object
     * @return true if this set contains the specified element
     */
    boolean contains(E object);

    /**
     * Returns the specified element if this set contains the specified element. More formally, returns the specified
     * element if and only if this set contains an element e such that Objects.equals(o, e). If not returns null.
     *
     * @param object
     * @return the specified element if this set contains it and null if not
     */
    E search(E object);

    /**
     * Removes the specified element from this set if it is present. More formally, removes an element e such that
     * Objects.equals(o, e), if this set contains such an element. Returns true if this set contained the element (or
     * equivalently, if this set changed as a result of the call). (This set will not contain the element once the call
     * returns.)
     *
     * @param object
     * @return true if this set contained the specified element
     */
    boolean remove(E object);

    /**
     * Returns true if this set contains no element.
     *
     * @return true if this set contains no elements
     */
    boolean isEmpty();
}
