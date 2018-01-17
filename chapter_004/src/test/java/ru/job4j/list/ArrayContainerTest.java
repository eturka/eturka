package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Test class ArrayContainer.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 15.01.2018
 */
public class ArrayContainerTest {

    /**
     * Test can add element in container and container is extendable,
     * attempt to get element which doesn't exist causes exception.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddThanCanGet() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(5);
        assertThat(container.get(0), is(5));
        for (int i = 0; i < 100; i++) {
            container.add(i);
        }
        assertThat(container.get(100), is(99));
        container.get(101);
    }

    /**
     * Test if iterator hasNext then it returns element,
     * attempt to get next if hasNext return false causes exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenHasNextNumberThanGetNextNumber() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(5);
        Iterator<Integer> iterator = container.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(5));
        assertFalse(iterator.hasNext());
        iterator.next();
    }
}