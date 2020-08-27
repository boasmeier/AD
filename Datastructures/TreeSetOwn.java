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
public final class TreeSetOwn<E> implements TreeInterface<E> {

    private static final Logger LOG = LogManager.getLogger(TreeSetOwn.class);
    private TreeNode<E> root;

    public TreeSetOwn() {

    }

    @Override
    public final boolean add(E object) {
        TreeNode<E> actualNode = this.root;
        while (actualNode != null) {
            if (object.hashCode() > actualNode.getKey()) {
                if (actualNode.getRightChild() != null) {
                    actualNode = actualNode.getRightChild();
                } else {
                    actualNode.setRightChild(new TreeNode<>(object, actualNode));
                    return true;
                }
            } else if (object.hashCode() < actualNode.getKey()) {
                if (actualNode.getLeftChild() != null) {
                    actualNode = actualNode.getLeftChild();
                } else {
                    actualNode.setLeftChild(new TreeNode<>(object, actualNode));
                    return true;
                }
            } else {
                LOG.info("This element is already in the tree!");
                return false;
            }
        }
        this.root = new TreeNode<>(object, null);
        return true;
    }

    @Override
    public final boolean contains(E object) {
        TreeNode<E> actualNode = this.root;
        while (actualNode != null) {
            if (object.hashCode() > actualNode.getKey()) {
                actualNode = actualNode.getRightChild();
            } else if (object.hashCode() < actualNode.getKey()) {
                actualNode = actualNode.getLeftChild();
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean remove(E object) {
        TreeNode<E> actualNode = this.root;
        while (actualNode != null) {
            if (object.hashCode() > actualNode.getKey()) {
                actualNode = actualNode.getRightChild();
            } else if (object.hashCode() < actualNode.getKey()) {
                actualNode = actualNode.getLeftChild();
            } else {
                if (actualNode.getLeftChild() != null && actualNode.getRightChild() != null) {
                    if (actualNode == this.root) {
                        this.root = findLeafForNewRoot();
                        if (this.root.getKey() > this.root.getParent().getKey()) {
                            this.root.getParent().setRightChild(null);
                        } else {
                            this.root.getParent().setLeftChild(null);
                        }
                        this.root.setParent(null);
                    } else if (actualNode.getKey() > actualNode.getParent().getKey()) {
                        actualNode.getParent().setRightChild(actualNode.getLeftChild());
                        findNextOpenSpaceForRightChild(actualNode.getLeftChild()).setRightChild(actualNode.getRightChild());
                    } else {
                        actualNode.getParent().setLeftChild(actualNode.getLeftChild());
                        findNextOpenSpaceForRightChild(actualNode.getLeftChild()).setRightChild(actualNode.getRightChild());
                    }
                    actualNode = null;
                } else if (actualNode.getLeftChild() == null && actualNode.getRightChild() != null) {
                    if (actualNode == this.root) {
                        this.root = findLeafForNewRoot();
                        if (this.root.getKey() > this.root.getParent().getKey()) {
                            this.root.getParent().setRightChild(null);
                        } else {
                            this.root.getParent().setLeftChild(null);
                        }
                        this.root.setParent(null);
                    } else if (actualNode.getKey() > actualNode.getParent().getKey()) {
                        actualNode.getParent().setRightChild(actualNode.getRightChild());
                    } else {
                        actualNode.getParent().setLeftChild(actualNode.getRightChild());
                    }
                    actualNode = null;
                } else if (actualNode.getLeftChild() != null && actualNode.getRightChild() == null) {
                    if (actualNode == this.root) {
                        this.root = findLeafForNewRoot();
                        if (this.root.getKey() > this.root.getParent().getKey()) {
                            this.root.getParent().setRightChild(null);
                        } else {
                            this.root.getParent().setLeftChild(null);
                        }
                        this.root.setParent(null);
                    } else if (actualNode.getKey() > actualNode.getParent().getKey()) {
                        actualNode.getParent().setRightChild(actualNode.getLeftChild());
                    } else {
                        actualNode.getParent().setLeftChild(actualNode.getLeftChild());
                    }
                    actualNode = null;
                } else {
                    //LOG.info("Actual Node: " + actualNode + " Parent: " + actualNode.getParent() + " LeftChild: " + actualNode.getLeftChild() + " Right Child: " + actualNode.getRightChild());
                    if (actualNode.getKey() > actualNode.getParent().getKey()) {
                        actualNode.getParent().setRightChild(null);
                    } else {
                        actualNode.getParent().setLeftChild(null);
                    }
                    actualNode = null;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public final E search(E object) {
        TreeNode<E> actualNode = this.root;
        while (actualNode != null) {
            if (object.hashCode() > actualNode.getKey()) {
                actualNode = actualNode.getRightChild();
            } else if (object.hashCode() < actualNode.getKey()) {
                actualNode = actualNode.getLeftChild();
            } else {
                return actualNode.getElement();
            }
        }
        return null;
    }

    private TreeNode<E> findLeafForNewRoot() {
        TreeNode<E> leaf = this.root.getRightChild();
        while (leaf.getLeftChild() != null && leaf.getRightChild() != null) {
            leaf = findNextOpenSpaceForLeftChild(leaf);
            if (leaf.getRightChild() != null) {
                leaf = leaf.getRightChild();
            }
        }
        return leaf;
    }

    private TreeNode<E> findNextOpenSpaceForRightChild(final TreeNode<E> node) {
        TreeNode<E> nodeWithOpenSpace = node;
        while (nodeWithOpenSpace != null) {
            if (nodeWithOpenSpace.getRightChild() != null) {
                nodeWithOpenSpace = nodeWithOpenSpace.getRightChild();
            } else {
                return nodeWithOpenSpace;
            }
        }
        return null;
    }

    private TreeNode<E> findNextOpenSpaceForLeftChild(final TreeNode<E> node) {
        TreeNode<E> nodeWithOpenSpace = node;
        while (nodeWithOpenSpace != null) {
            if (nodeWithOpenSpace.getLeftChild() != null) {
                nodeWithOpenSpace = nodeWithOpenSpace.getLeftChild();
            } else {
                return nodeWithOpenSpace;
            }
        }
        return null;
    }

    public final TreeNode<E> getRoot() {
        return this.root;
    }

    public final void traverse() {
        inorderTraverse(this.root);
        //postorderTraverse(this.root);
        //preorderTraverse(this.root);
    }

    private void inorderTraverse(TreeNode<E> node) {
        if (node != null) {
            inorderTraverse(node.getLeftChild());
            LOG.info(node.getElement());
            inorderTraverse(node.getRightChild());
        }
    }

    private void preorderTraverse(TreeNode<E> node) {
        if (node != null) {
            LOG.info(node.getElement());
            preorderTraverse(node.getLeftChild());
            preorderTraverse(node.getRightChild());
        }
    }

    private void postorderTraverse(TreeNode<E> node) {
        if (node != null) {
            postorderTraverse(node.getLeftChild());
            postorderTraverse(node.getRightChild());
            LOG.info(node.getElement());
        }
    }
}
