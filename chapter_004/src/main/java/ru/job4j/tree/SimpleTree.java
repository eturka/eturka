package ru.job4j.tree;

import java.util.Optional;

/**
 * Interface SimpleTree.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 03.02.2018
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<Node<E>> {
    /**
     * Add new child to the parent.
     *
     * @param parent branch node
     * @param child  leave node
     * @return true | false if was added, if wasn't
     */
    boolean add(E parent, E child);

    /**
     * Looking for leaf by the value.
     *
     * @param value of searching leaf
     * @return leaf covered by optional
     */
    Optional<Node<E>> findBy(E value);
}
