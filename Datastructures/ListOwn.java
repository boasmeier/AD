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
public final class ListOwn<E> {

    private static final Logger LOG = LogManager.getLogger(ListOwn.class);

    private int size;
    private Node<E> head;

    public ListOwn() {

    }

    public final void add(final E object) {
        @SuppressWarnings("unchecked")
        Node<E> node = new Node<>(object, this.getHead());
        this.head = node;
        this.size++;
    }

    public final void add(final E object, final E object2) {
        this.add(object);
        this.add(object2);
    }

    @SuppressWarnings("unchecked")
    public final E removeHead() {
        Node<E> newHead = this.getHead().getNext();
        Object oldHeadElement = this.getHead().getElement();
        this.setHead(newHead);
        this.size--;
        return (E) oldHeadElement;
    }

    public final boolean contains(final Object object) {
        if (!(object instanceof Allocation) || (this.getSize() <= 0)) {
            return false;
        } else {
            Allocation other = (Allocation) object;
            @SuppressWarnings("unchecked")
            Node<E> nodeOfElementOfList = this.getHead();
            while (nodeOfElementOfList != null) {
                if (other.equals(nodeOfElementOfList.getElement())) {
                    return true;
                }
                nodeOfElementOfList = nodeOfElementOfList.getNext();
            }
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public final boolean remove(final Object object) {
        if (!(object instanceof Allocation) || (this.getSize() <= 0)) {
            LOG.info("The Object: " + object + "isn't a Element of this list");
            return false;
        } else {
            Allocation other = (Allocation) object;
            Node<E> nodeOfElementOfList = this.getHead();
            Node<E> previous = null;
            while (nodeOfElementOfList != null) {
                if (other.equals(nodeOfElementOfList.getElement())) {
                    if (nodeOfElementOfList == this.getHead()) {
                        if (nodeOfElementOfList.getNext() == null) {
                            this.setHead(null);
                            this.size--;
                            return true;
                        } else {
                            this.setHead(nodeOfElementOfList.getNext());
                            this.size--;
                            return true;
                        }
                    } else if (nodeOfElementOfList.getNext() == null) {
                        previous.setNext(null);
                        this.size--;
                        return true;
                    } else if (nodeOfElementOfList.getNext() != null) {
                        previous.setNext(nodeOfElementOfList.getNext());
                        this.size--;
                        return true;
                    }
                }
                previous = nodeOfElementOfList;
                nodeOfElementOfList = nodeOfElementOfList.getNext();
            }
            return false;
        }
    }

    public final int getSize() {
        return this.size;
    }

    public final Node<E> getHead() {
        return this.head;
    }

    public final void setSize(int size) {
        this.size = size;
    }

    public final void setHead(Node<E> head) {
        this.head = head;
    }
}
