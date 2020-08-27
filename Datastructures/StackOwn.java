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
public class StackOwn<E> implements StackInterface<E> {

    private static final Logger LOG = LogManager.getLogger(StackOwn.class);

    private int size;
    private final int arraySize;
    private E objectAtTheTop;

    private final E[] array;

    public StackOwn(int size) {
        this.array = (E[]) new Object[size];
        this.arraySize = size;
    }

    @Override
    public final boolean empty() {
        return !(this.size > 0);
    }

    @Override
    public final E peek() {
        return objectAtTheTop;
    }

    @Override
    public final E pop() {
        if (this.peek() != null) {
            E itemToPop = this.peek();
            array[this.size - 1] = null;
            this.size--;
            this.setObjectAtTheTop(array[this.size - 1]);
            return itemToPop;
        } else {
            LOG.info("The Stack is empty - there is nothing to pop!");
            return null;
        }
    }

    @Override
    public final E push(E item) {
        if (this.size < arraySize) {
            array[this.size] = item;
            this.setObjectAtTheTop(item);
            this.size++;
            return this.peek();
        } else {
            for (int i = 0; i < arraySize - 1; i++) {
                array[i] = array[i + 1];
            }
            array[arraySize - 1] = item;
            LOG.info("Item at the bottom of the stack was removed in order to make place for the new one!");
            return this.peek();
        }

    }

    public final int getSize() {
        return size;
    }

    public final void setSize(int size) {
        this.size = size;
    }

    public final void setObjectAtTheTop(E objectAtTheTop) {
        this.objectAtTheTop = objectAtTheTop;
    }

}
