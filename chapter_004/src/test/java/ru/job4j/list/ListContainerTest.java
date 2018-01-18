package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Test class ListContainer.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 15.01.2018
 */
public class ListContainerTest {

    /**
     * Test can add element in container and,
     * attempt to get element which doesn't exist causes exception.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddThanCanGet() {
        ListContainer<Integer> container = new ListContainer<>();
        container.add(5);
        assertThat(container.get(0), is(5));
        container.get(1);
    }

    /**
     * Test if iterator hasNext then it returns element,
     * attempt to get next if hasNext return false causes exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenHasNextNumberThanGetNextNumber() {
        ListContainer<Integer> container = new ListContainer<>();
        container.add(5);
        Iterator<Integer> iterator = container.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(5));
        assertFalse(iterator.hasNext());
        iterator.next();
    }
}