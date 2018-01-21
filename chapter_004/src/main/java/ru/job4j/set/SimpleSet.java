package ru.job4j.set;

import ru.job4j.list.ListContainer;

import java.util.Iterator;

/**
 * Class SimpleSet.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 21.01.2018
 */
public class SimpleSet<T> implements Iterable<T> {
    /**
     * Base container.
     */
    private final ListContainer<T> array = new ListContainer<>();

    /**
     * Add new element.
     *
     * @param value some element
     */
    public void add(T value) {
        boolean add = true;
        for (T element : this.array) {
            if (element.equals(value)) {
                add = false;
                break;
            }
        }
        if (add) {
            this.array.add(value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return this.array.iterator();
    }
}
