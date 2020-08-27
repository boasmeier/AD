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
public final class TreeNode<E> {

    private static final Logger LOG = LogManager.getLogger(TreeNode.class);

    private TreeNode<E> leftChild;
    private final E element;
    private TreeNode<E> rightChild;
    private TreeNode<E> parent;
    private final int key;

    public TreeNode(E element, TreeNode<E> parent) {
        this.element = element;
        this.key = element.hashCode();
        this.parent = parent;
    }

    public void setLeftChild(TreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(TreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode<E> getLeftChild() {
        return leftChild;
    }

    public E getElement() {
        return element;
    }

    public TreeNode<E> getRightChild() {
        return this.rightChild;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public final TreeNode<E> getParent() {
        return this.parent;
    }

    public int getKey() {
        return this.key;
    }

    @Override
    public String toString() {
        return "TreeNode{" + "leftChild=" + leftChild + ", element=" + element + ", rightChild=" + rightChild + '}';
    }
}
