package ru.job4j.generic;

import java.util.Iterator;

/**
 * Class SimpleArray.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 13.01.2018
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Container for basic class.
     */
    private Object[] array;
    /**
     * Count of filled elements in array.
     */
    private int count = 0;

    /**
     * Create SimpleArray defined size.
     *
     * @param size of array
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Add new element.
     *
     * @param value some element
     */
    public void add(T value) {
        this.array[this.count++] = value;
    }

    /**
     * Update element which locate on the position with value.
     *
     * @param position location of element
     * @param value    new value of element
     * @return true | false if updated, if cannot update
     */
    public boolean update(int position, T value) {
        boolean updated = this.inRange(position);
        if (updated) {
            this.array[position] = value;
        }
        return updated;
    }

    /**
     * Remove element located on the position.
     *
     * @param position index of the element
     * @return true | false if deleted, if cannot remove
     */
    public boolean delete(int position) {
        boolean deleted = this.inRange(position);
        if (deleted) {
            System.arraycopy(this.array, position + 1, this.array, position, this.array.length - 1 - position);
            this.array[--this.count] = null;
        }
        return deleted;
    }

    /**
     * Get element from array.
     *
     * @param position index of the element
     * @return element
     */
    public T get(int position) {
        return (T) this.array[position];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * Current position.
             */
            int position = 0;

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean hasNext() {
                return this.position < count;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public T next() {
                return (T) array[this.position++];
            }
        };
    }

    /**
     * Check if the position is in range.
     *
     * @param position index
     * @return true | false if position is in range, if isn't
     */
    private boolean inRange(int position) {
        return position < this.count && position >= 0;
    }
}
