package ru.job4j.tree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Class BinarySearchTree.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 08.02.2018
 */
public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {
    /**
     * Root node of the tree.
     */
    private Node root;

    /**
     * Create tree with root initialized by the value.
     *
     * @param value root element
     */
    public BinarySearchTree(E value) {
        this.root = new Node(value);
    }

    /**
     * Add new element to the tree if it not added already.
     *
     * @param element new value
     * @return true | false if element was added, else
     */
    public boolean add(E element) {
        return this.root.add(element);
    }

    /**
     * Looking for element in the tree.
     *
     * @param element looking for value
     * @return true | false if found element, else
     */
    public boolean find(E element) {
        return this.root.find(element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * Stack of all nodes of the tree.
             */
            Stack<E> nodes = new Stack<>();

            {
                this.fill(root);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean hasNext() {
                return !nodes.empty();
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public E next() {
                if (nodes.empty()) {
                    throw new NoSuchElementException();
                }
                return nodes.pop();
            }

            /**
             * Fill stack by node and it's children in reverse order.
             *
             * @param node current element
             */
            private void fill(Node node) {
                if (node.right != null) {
                    this.fill(node.right);
                }
                this.nodes.push(node.value);
                if (node.left != null) {
                    this.fill(node.left);
                }
            }
        };
    }

    /**
     * Class Node presents container to a sorted binary tree structure.
     */
    private class Node {
        /**
         * Node value.
         */
        private E value;
        /**
         * Children of the node, left - smaller, right - larger.
         */
        private Node left, right;

        /**
         * Create new node fill with the value.
         *
         * @param value new element
         */
        public Node(E value) {
            this.value = value;
        }

        /**
         * Add new element to the node structure.
         *
         * @param element new node value
         * @return true | false if element added, else
         */
        public boolean add(E element) {
            boolean added = false;
            int comparison = this.value.compareTo(element);
            if (comparison > 0) {
                added = addLeft(element);
            } else if (comparison < 0) {
                added = addRight(element);
            }
            return added;
        }

        /**
         * Looking for element in the node structure by binary search.
         *
         * @param element looking for value
         * @return true | false if found element, else
         */
        public boolean find(E element) {
            boolean found = true;
            int comparison = this.value.compareTo(element);
            if (comparison > 0) {
                found = (this.left != null) && this.left.find(element);
            } else if (comparison < 0) {
                found = (this.right != null) && this.right.find(element);
            }
            return found;
        }

        /**
         * Add element to the left branch.
         *
         * @param element new node value
         * @return true | false if element added, else
         */
        private boolean addLeft(E element) {
            boolean added = true;
            if (left == null) {
                left = new Node(element);
            } else {
                added = left.add(element);
            }
            return added;
        }

        /**
         * Add element to the right branch.
         *
         * @param element new node value
         * @return true | false if element added, else
         */
        private boolean addRight(E element) {
            boolean added = true;
            if (right == null) {
                right = new Node(element);
            } else {
                added = right.add(element);
            }
            return added;
        }
    }
}
