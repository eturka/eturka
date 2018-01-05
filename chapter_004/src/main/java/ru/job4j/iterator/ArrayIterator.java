package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ArrayIterator.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 05.01.2018
 */
public class ArrayIterator implements Iterator {
    /**
     * Two dimension array.
     */
    private final int[][] values;
    /**
     * Current cell in array.
     */
    private int line = 0, column = 0;

    /**
     * Initialize ArrayIterator with array.
     *
     * @param values 2D array
     */
    public ArrayIterator(final int[][] values) {
        this.values = values;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        return line < values.length && (column < values[line].length || (line != values.length - 1));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        Integer result = values[line][column];
        if (column < values[line].length - 1) {
            column++;
        } else {
            line++;
            column = 0;
        }
        return result;
    }
}
