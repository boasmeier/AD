/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW07;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 * @param <E>
 */
public class HashSetWithBuckets<E> implements HashSetInterface<E> {

    private static final Logger LOG = LogManager.getLogger(HashSetWithBuckets.class);

    private final Node<E>[] array;
    private final int lenght;
    private int size;

    @SuppressWarnings("unchecked")
    public HashSetWithBuckets(int lenght) {
        this.array = (Node<E>[]) new Object[lenght];
        this.lenght = lenght;
    }

    @Override
    @SuppressWarnings("unchecked")
    public final boolean add(E object) throws ArrayIndexOutOfBoundsException {
        final int index = calcIndex(object);
        if (!contains(object) && this.array[index] == null) {
            Node<E> node = new Node<>(object, null);
            this.array[index] = node;
            this.size++;
            return true;
        } else if (this.array[index] != null) {
            Node<E> node = new Node<>(object, this.array[index]);
            this.array[index] = node;
            this.size++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final boolean remove(E object) {
        final int index = this.calcIndex(object);
        if (contains(object)) {
            // If the List at this index contains only one element, the element to remove
            if (object.equals(this.array[index].getElement()) && this.array[index].getNext() == null) {
                this.array[index] = null;
                this.size--;
                return true;
                // If the List at this index contains more elements than only the one to remove
            } else if (object.equals(this.array[index].getElement()) && this.array[index].getNext() != null) {
                this.array[index] = this.array[index].getNext();
                this.size--;
                return true;
                // If the element to remove is not the first in the List
            } else if (!object.equals(this.array[index].getElement()) && this.array[index].getNext() != null) {
                Node<E> next = this.array[index];
                while (next != null) {
                    if (object.equals(next.getNext())) {
                        if (next.getNext().getNext() != null) {
                            next.setNext(next.getNext().getNext());
                            this.size--;
                            return true;
                        } else {
                            next.setNext(null);
                            this.size--;
                            return true;
                        }
                    } else {
                        next = next.getNext();
                    }
                }
            }
        }
        return false;
    }

    @Override
    public final boolean contains(E object) {
        final int index = this.calcIndex(object);
        //If Element is at first position of its real index return true
        if (object.equals(this.array[index].getElement())) {
            return true;
        }

        //If Element isn't at its real index test if it's in the list
        Node<E> next = this.array[index].getNext();
        while (next != null) {
            if (object.equals(next.getElement())) {
                return true;
            } else {
                next = next.getNext();
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public int calcIndex(E object) {
        return object.hashCode() % lenght;
    }

    @Override
    public String toString() {
        return "HashSet{" + "array=" + Arrays.toString(array) + ", lenght=" + lenght + '}';
    }
}
