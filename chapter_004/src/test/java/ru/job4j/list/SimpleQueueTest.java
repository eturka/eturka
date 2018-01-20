package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Test class SimpleQueue.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 20.01.2018
 */
public class SimpleQueueTest {
    /**
     * Check that FIFO.
     */
    @Test
    public void whenPushOneTwoThanPollOneTwoNull() {
        SimpleQueue<Integer> stack = new SimpleQueue<>();
        stack.push(1);
        stack.push(2);
        assertThat(stack.poll(), is(1));
        assertThat(stack.poll(), is(2));
        assertNull(stack.poll());
    }
}