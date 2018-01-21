package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Test class SimpleSet.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 21.01.2018
 */
public class SimpleSetTest {
    /**
     * Check when add then can get without duplicates.
     */
    @Test
    public void whenAddOneZeroOneTwoThenGetOneZeroTwo() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("one");
        set.add("zero");
        set.add("one");
        set.add("two");
        Iterator<String> iterator = set.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), "one");
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), "zero");
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), "two");
        assertFalse(iterator.hasNext());
    }
}