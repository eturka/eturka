package ru.job4j.tree;

import java.util.*;

/**
 * Class Tree.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 03.02.2018
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Root node of the tree.
     */
    private final Node<E> root;

    /**
     * Create new tree with the root.
     *
     * @param root node of the tree
     */
    public Tree(E root) {
        this.root = new Node<>(root);
    }

    /**
     * Add new child to the parent.
     *
     * @param parent branch node
     * @param child  leave node
     * @return true | false if was added, if parent wasn't found or leaf with value child already exist
     */
    @Override
    public boolean add(E parent, E child) {
        boolean added = false;
        Optional<Node<E>> leaf = findBy(child);
        if (!leaf.isPresent()) {
            leaf = findBy(parent);
            if (leaf.isPresent()) {
                leaf.get().add(new Node<>(child));
                added = true;
            }
        }
        return added;
    }

    /**
     * Looking for leaf by the value.
     *
     * @param value of searching leaf
     * @return leaf covered by optional
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Iterator<Node<E>> nodes = iterator();
        Node<E> current;
        while (nodes.hasNext()) {
            current = nodes.next();
            if (current.eqValue(value)) {
                result = Optional.of(current);
                break;
            }
        }
        return result;
    }

    /**
     * Check if this tree is binary.
     *
     * @return true | false if tree is binary, it isn't
     */
    public boolean isBinary() {
        boolean binary = true;
        Iterator<Node<E>> nodes = iterator();
        Node<E> current;
        while (nodes.hasNext()) {
            current = nodes.next();
            if (current.leaves().size() > 2) {
                binary = false;
                break;
            }
        }
        return binary;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<Node<E>> iterator() {
        return new Iterator<Node<E>>() {
            /**
             * Queue for leaves initialized by root of the tree.
             */
            private Queue<Node<E>> nodes;

            {
                nodes = new LinkedList<>();
                nodes.offer(root);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean hasNext() {
                return !this.nodes.isEmpty();
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public Node<E> next() {
                if (this.nodes.isEmpty()) {
                    throw new NoSuchElementException();
                }
                Node<E> element = this.nodes.poll();
                for (Node<E> leaf : element.leaves()) {
                    this.nodes.offer(leaf);
                }
                return element;
            }
        };
    }
}
