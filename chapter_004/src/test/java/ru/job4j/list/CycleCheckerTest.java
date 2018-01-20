package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class CycleChecker.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 21.01.2018
 */
public class CycleCheckerTest {
    /**
     * Check if list has cycle than return true.
     */
    @Test
    public void whenHasCycleThanTrue() {
        CycleChecker checker = new CycleChecker();

        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);

        first.setNext(two);
        two.setNext(third);
        third.setNext(two);

        assertTrue(checker.hasCycle(first));
    }

    /**
     * Check if list has no cycle than return false.
     */
    @Test
    public void whenWithoutCycleThanFalse() {
        CycleChecker checker = new CycleChecker();

        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);

        first.setNext(two);
        two.setNext(third);

        assertFalse(checker.hasCycle(first));
    }
}