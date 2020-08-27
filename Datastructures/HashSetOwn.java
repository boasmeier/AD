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
public final class HashSetOwn<E> implements HashSetInterface<E> {

    private static final Logger LOG = LogManager.getLogger(HashSetOwn.class);

    private final E[] array;
    private final int lenght;
    private int size;
    private final E tombstone;

    @SuppressWarnings("unchecked")
    public HashSetOwn(int lenght) {
        this.array = (E[]) new Object[lenght];
        this.lenght = lenght;
        this.tombstone = (E) new Object();
    }

    @Override
    public final boolean add(E object) throws ArrayIndexOutOfBoundsException {
        if (!contains(object) && this.array[calcIndex(object)] == null) {
            this.array[calcIndex(object)] = object;
            this.size++;
            return true;
        } else if (this.array[calcIndex(object)] != null) {
            this.array[this.sondieren(object)] = object;
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
            if (object.equals(this.array[index])) {
                this.array[index] = null;
                this.size--;
                return true;
            } else {
                //If Element isn't at its real index test if its on an other index
                int nextIndex;
                if (index >= 9) {
                    nextIndex = 0;
                } else {
                    nextIndex = index + 1;
                }
                while (nextIndex != index) {
                    if (object.equals(this.array[nextIndex])) {
                        this.array[nextIndex] = this.tombstone;
                        this.size--;
                        return true;
                    } else if (this.array[nextIndex] != null) {
                        if (nextIndex < this.lenght - 1) {
                            nextIndex++;
                        } else {
                            nextIndex = 0;
                        }
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return false;
    }

    @Override
    public final boolean contains(E object) {
        final int index = this.calcIndex(object);
        //If Element is at its real index return true
        if (object.equals(this.array[index])) {
            return true;
        }

        //If Element isn't at its real index test if its on an other index
        int nextIndex;
        if (index >= 9) {
            nextIndex = 0;
        } else {
            nextIndex = index + 1;
        }
        while (nextIndex != index) {
            if (object.equals(this.array[nextIndex])) {
                return true;
            } else if (this.array[nextIndex] != null) {
                if (nextIndex < this.lenght - 1) {
                    nextIndex++;
                } else {
                    nextIndex = 0;
                }
            } else {
                return false;
            }
            //LOG.info("Tombstone Test!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        return false;
    }

    public int size() {
        return size;
    }

    public int calcIndex(E object) {
        return object.hashCode() % lenght;
    }

    private int sondieren(final E object) {
        final int index = this.calcIndex(object);
        int nextFreeIndex;
        if (index >= 9) {
            nextFreeIndex = 0;
        } else {
            nextFreeIndex = index + 1;
        }

        while (nextFreeIndex != index) {
            if (this.array[nextFreeIndex] == null) {
                return nextFreeIndex;
            } else {
                if (nextFreeIndex < this.lenght - 1) {
                    nextFreeIndex++;
                } else {
                    nextFreeIndex = 0;
                }
            }
        }
        throw new ArrayIndexOutOfBoundsException("Array is full!");
    }

    @Override
    public String toString() {
        return "HashSet{" + "array=" + Arrays.toString(array) + ", lenght=" + lenght + '}';
    }
}
