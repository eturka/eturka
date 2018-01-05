package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class PrimeIterator.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 05.01.2018
 */
public class PrimeIterator implements Iterator {
    /**
     * Array which may contain prime numbers.
     */
    private final int[] values;
    /**
     * Current index.
     */
    private int index = -1;

    /**
     * Create iterator PrimeIterator filled by values.
     *
     * @param values array of int
     */
    public PrimeIterator(final int[] values) {
        this.values = values;
        this.index = getNextPrimeIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        return this.index >= 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object next() {
        if (this.index < 0) {
            throw new NoSuchElementException();
        }
        Integer result = this.values[this.index];
        this.index = getNextPrimeIndex();
        return result;
    }

    /**
     * Return next prime element index in array values.
     *
     * @return index of next prime in values or -1 if only not prime in array stayed
     */
    private int getNextPrimeIndex() {
        int primeIndex = -1;
        for (int i = index + 1; i < this.values.length; i++) {
            boolean isPrime = this.values[i] > 1;
            for (int j = 2; j <= this.values[i] / 2; j++) {
                if (this.values[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeIndex = i;
                break;
            }
        }
        return primeIndex;
    }
}
