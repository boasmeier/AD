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
public class QueueOwn implements QueueInterface {

    private static final Logger LOG = LogManager.getLogger(QueueOwn.class);

    private int size;
    private final int queueSize;
    private Character head;
    private int indexHead;
    private int tail;

    private final Character[] array;

    public QueueOwn(final int size) {
        this.array = new Character[size];
        this.queueSize = size;
        this.tail = 0;
    }

    @Override
    public final boolean add(Character letter) {
        if (this.size <= this.queueSize - 1) {
            array[tail] = letter;
            if (this.head == null) {
                this.head = letter;
                this.indexHead = 0;
            }
            if (this.tail >= this.queueSize - 1) {
                this.tail = 0;
            } else {
                this.tail++;
            }
            this.size++;
            return true;
        } else {
            throw new IllegalStateException("This Queue is full!");
        }
    }

    @Override
    public final Character poll() {
        Character itemToPoll = this.head;
        if (this.size >= 2) {
            this.head = array[this.indexHead + 1];
            array[this.indexHead] = null;
            if (this.indexHead >= this.queueSize - 1) {
                this.indexHead = 0;
            } else {
                this.indexHead++;
            }
            this.size--;
            return itemToPoll;
        } else if (this.size >= 1) {
            array[this.indexHead] = null;
            this.size--;
            return itemToPoll;
        } else {
            return null;
        }
    }

    @Override
    public final Character peek() {
        return this.head;
    }

    public final int getSize() {
        return this.size;
    }

    public final Character getHead() {
        return head;
    }

    public final int getTail() {
        return tail;
    }

    public final void setSize(int size) {
        this.size = size;
    }

    public final void setHead(Character head) {
        this.head = head;
    }

    public final void setTail(int tail) {
        this.tail = tail;
    }
}
