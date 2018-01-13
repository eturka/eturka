package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Class Converter.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 13.01.2018
 */
public class Converter {
    /**
     * Convert iterator of iterators to iterator.
     *
     * @param it iterator of iterators of integer
     * @return iterator of integer
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            /**
             * Temporary iterator.
             */
            Iterator<Integer> iterator = it.next();

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean hasNext() {
                boolean has = false;
                while (iterator.hasNext() || it.hasNext()) {
                    if (iterator.hasNext()) {
                        has = true;
                        break;
                    }
                    iterator = it.next();
                }
                return has;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public Integer next() {
                while (!iterator.hasNext()) {
                    iterator = it.next();
                }
                return iterator.next();
            }
        };
    }
}
