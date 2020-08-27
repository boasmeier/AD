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
 * @param <E>
 */
public final class Node<E> {

    private static final Logger LOG = LogManager.getLogger(Node.class);

    private Node<E> next;
    //private final int startAddressOfElement;
    //private final int sizeOfElement;
    private final E element;

    public Node(final E element, final Node<E> next) {
        this.element = element;
        //this.startAddressOfElement = this.element.getStartAddress();
        //this.sizeOfElement = this.element.getSize();
        this.next = next;
    }

    /*
    public final int getStartAddressOfElement() {
        return startAddressOfElement;
    }

    public final int getSizeOfElement() {
        return sizeOfElement;
    }
     */
    public final E getElement() {
        return element;
    }

    public final Node<E> getElementNode() {
        return this;
    }

    public final Node<E> getNext() {
        return next;
    }

    public final void setNext(Node<E> next) {
        this.next = next;
    }
}
