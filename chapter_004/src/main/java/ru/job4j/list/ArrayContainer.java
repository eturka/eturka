package ru.job4j.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Container.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 15.01.2018
 */
@ThreadSafe
public class ArrayContainer<E> implements Iterable<E> {
    /**
     * Array of objects.
     */
    @GuardedBy("this")
    private Object[] container = new Object[100];
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
        if (this.size >= this.container.length) {
            this.container = Arrays.copyOf(this.container, this.size * 2);
        }
        this.modCount++;
        this.container[this.size++] = value;
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
        return (E) this.container[index];
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
             * Current position.
             */
            private int index = 0;

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean hasNext() {
                synchronized (ArrayContainer.this) {
                    checkMod();
                    return this.index < size;
                }
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public E next() {
                synchronized (ArrayContainer.this) {
                    checkMod();
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return (E) container[this.index++];
                }
            }

            /**
             * Check if container structure was modified.
             *
             * @throws ConcurrentModificationException if there was modification after iterator creation
             */
            private void checkMod() {
                synchronized (ArrayContainer.this) {
                    if (modCount > this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }
            }
        };
    }
}
