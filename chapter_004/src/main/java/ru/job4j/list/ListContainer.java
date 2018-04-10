package ru.job4j.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ListContainer.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 18.01.2018
 */
@ThreadSafe
public class ListContainer<E> implements Iterable<E> {
    /**
     * Link on first element of the list.
     */
    @GuardedBy("this")
    private Node<E> first = null;
    /**
     * Last element of the list.
     */
    @GuardedBy("this")
    private Node<E> last = null;
    /**
     * Count of filed elements of container.
     */
    @GuardedBy("this")
    private int size = 0;
    /**
     * Modifications count.
     */
    @GuardedBy("this")
    private int modCount = 0;

    /**
     * Add new element to container.
     *
     * @param value new element
     */
    public synchronized void add(E value) {
        if (this.first == null || this.last == null) {
            this.first = new Node<>(value);
            this.last = this.first;
        } else {
            this.last.setNext(new Node<>(value));
            this.last = this.last.getNext();
        }
        this.modCount++;
        this.size++;
    }

    /**
     * Return element by index.
     *
     * @param index ordinal number of the element
     * @return element
     * @throws IndexOutOfBoundsException if index is negative or larger than size of container
     */
    public synchronized E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> element = first;
        while (index-- != 0) {
            element = element.getNext();
        }
        return element.getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * Modifications count then the iterator was created.
             */
            private final int expectedModCount = modCount;
            /**
             * Current element.
             */
            private Node<E> element = first;

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean hasNext() {
                checkMod();
                return this.element != null;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public E next() {
                checkMod();
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = this.element.getValue();
                this.element = this.element.getNext();
                return value;
            }

            /**
             * Check if container structure was modified.
             *
             * @throws ConcurrentModificationException if there was modification after iterator creation
             */
            private void checkMod() {
                synchronized (ListContainer.this) {
                    if (modCount > this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }
            }
        };
    }
}
