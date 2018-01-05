package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenIterator.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 05.01.2018
 */
public class EvenIterator implements Iterator {
    /**
     * Array which may contain even numbers.
     */
    private final int[] values;
    /**
     * Current index.
     */
    private int index = -1;

    /**
     * Create iterator EvenIterator filled by values.
     *
     * @param values array of int
     */
    public EvenIterator(final int[] values) {
        this.values = values;
        index = getNextEvenIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object next() {
        if (index < 0) {
            throw new NoSuchElementException();
        }
        Integer result = values[index];
        index = getNextEvenIndex();
        return result;
    }

    /**
     * Return next even element index in array values.
     *
     * @return index of next even number in values or -1 if only odd numbers in array stayed
     */
    private int getNextEvenIndex() {
        int evenIndex = -1;
        for (int i = index + 1; i < this.values.length; i++) {
            if (this.values[i] % 2 == 0) {
                evenIndex = i;
                break;
            }
        }
        return evenIndex;
    }
}
