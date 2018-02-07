package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Node.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 03.02.2018
 */
public class Node<E extends Comparable<E>> {
    /**
     * List of children of the node.
     */
    private final List<Node<E>> children = new ArrayList<>();
    /**
     * Node value.
     */
    private final E value;

    /**
     * Create node with value without children.
     *
     * @param value of the node
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Add new child to the node.
     *
     * @param child of the node
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Returns all children of the node.
     *
     * @return children
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Check if values are the same for the comparator.
     *
     * @param that value for comparison
     * @return true | false if values are equals for comparator, if aren't
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }
}
