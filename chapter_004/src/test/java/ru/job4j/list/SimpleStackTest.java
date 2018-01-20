package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Test class SimpleStack.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 20.01.2018
 */
public class SimpleStackTest {
    /**
     * Check that LIFO.
     */
    @Test
    public void whenPushOneTwoThanPollTwoOneNull() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
        assertNull(stack.poll());
    }
}