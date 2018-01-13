package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class SimpleArray.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 13.01.2018
 */
public class SimpleArrayTest {
    /**
     * Test add method.
     */
    @Test
    public void whenAddNumberThenGetThisNumber() {
        SimpleArray<Integer> array = new SimpleArray<>(1);
        array.add(5);
        assertThat(array.get(0), is(5));
    }

    /**
     * Test update method.
     */
    @Test
    public void whenUpdateElementWithValueThenGetThisValue() {
        SimpleArray<String> array = new SimpleArray<>(1);
        array.add("old");
        assertTrue(array.update(0, "new"));
        assertEquals(array.get(0), "new");
    }

    /**
     * Test delete method.
     */
    @Test
    public void whenDeleteElementThenGetReturnNull() {
        SimpleArray<Integer> array = new SimpleArray<>(1);
        array.add(5);
        assertTrue(array.delete(0));
        assertNull(array.get(0));
    }

    /**
     * Test iterator.
     */
    @Test
    public void whenIterateThenGetSequenceOfElementsInSameOrder() {
        SimpleArray<Integer> array = new SimpleArray<>(2);
        array.add(4);
        array.add(2);
        Iterator<Integer> iterator = array.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(4));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(2));
        assertFalse(iterator.hasNext());
    }
}