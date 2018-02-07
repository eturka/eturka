package ru.job4j.tree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Test class Node.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 07.02.2018
 */
public class NodeTest {
    @Test
    public void whenNodeWithoutChildThenLeavesEmpty() {
        Node<Integer> node = new Node<>(1);
        List<Node<Integer>> leaves = node.leaves();
        assertTrue(leaves.isEmpty());
    }

    @Test
    public void whenAddChildTwoThenLeavesContainsTwo() {
        Node<Integer> node = new Node<>(1), leaf = new Node<>(2);
        node.add(leaf);
        List<Node<Integer>> leaves = node.leaves();
        assertTrue(leaves.contains(leaf));
    }

    @Test
    public void whenCompareNodeWithSameValueThenEqValueTrue() {
        Node<Integer> node = new Node<>(1);
        assertTrue(node.eqValue(1));
    }

    @Test
    public void whenCompareNodeWithDifferentValueThenEqValueFalse() {
        Node<Integer> node = new Node<>(1);
        assertFalse(node.eqValue(2));
    }
}
