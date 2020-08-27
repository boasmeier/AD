/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW10;

/**
 *
 * @author boasm
 */
public interface IntegerHeap {

    /**
     * Adds a Element to the Heap and reorganizes the Heap after.
     *
     * @param obj
     * @return true when successful otherwise false
     */
    boolean insert(int obj);

    /**
     * Returns the root of the heap witch is also the greatest element. Reorganizes the Heap afterwards.
     *
     * @return If exist root otherwise false
     */
    int getMax();

    /**
     * Returns index of the father node of the element at the specified index. If element don't exist returns null.
     *
     * @param i
     * @return If element at specified index exist return father, if not return null.
     */
    int father(int i);

    /**
     * Returns index left child of element at specified index.
     *
     * @param i
     * @return index of left child
     */
    int leftChild(int i);

    /**
     * Returns index right child of element at specified index.
     *
     * @param i
     * @return index of left child
     */
    int rightChild(int i);

    /**
     * Returns the object at the specified index of the array. Does not remove it.
     *
     * @param i
     * @return
     */
    int get(int i);
}
