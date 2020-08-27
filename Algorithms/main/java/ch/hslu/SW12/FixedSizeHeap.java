/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class FixedSizeHeap implements IntegerHeap {

    private static final Logger LOG = LogManager.getLogger(FixedSizeHeap.class);

    private final int size;
    private final int[] a;
    private int count;

    public FixedSizeHeap(int size) {
        this.size = 2 * (size + 1);     // Double array size to avoid IndexOutOfBoundsException
        this.a = new int[this.size];
        this.count = 0;
    }

    @Override
    public boolean insert(int obj) {

        // Throw Exception when array is full
        if (count >= size) {
            throw new IllegalArgumentException("Heap is full!");
        }

        a[count] = obj;
        int tmp;
        int i = count;

        // Swap new element up the tree till right position
        while (a[i] > a[father(i)] && i > 0) {
            tmp = a[i];
            a[i] = a[father(i)];
            a[father(i)] = tmp;
            i = father(i);
        }
        count++;
        return true;
    }

    @Override
    public int getMax() {
        int max;
        // If heap contains only one element return it. If heap is empty throw exception.
        if (count == 1) {
            count--;
            return a[0];
        } else if (count == 0) {
            throw new IllegalArgumentException("Heap is empty");
        }

        max = a[0];
        a[0] = a[count - 1];
        a[count - 1] = 0;
        int tmp;
        int i = 0;

        // Swap the root down the tree till right position
        while (a[i] < a[leftChild(i)] || a[i] < a[rightChild(i)]) {
            tmp = a[i];
            if (a[rightChild(i)] < a[leftChild(i)]) {
                a[i] = a[leftChild(i)];
                a[leftChild(i)] = tmp;
                i = leftChild(i);
            } else {
                a[i] = a[rightChild(i)];
                a[rightChild(i)] = tmp;
                i = rightChild(i);
            }
        }
        count--;
        return max;
    }

    @Override
    public int father(int i) {
        return (i - 1) / 2;
    }

    @Override
    public int leftChild(int i) {
        return (2 * i) + 1;
    }

    @Override
    public int rightChild(int i) {
        return 2 * (i + 1);
    }

    @Override
    public int get(int i) {
        return a[i];
    }

}
