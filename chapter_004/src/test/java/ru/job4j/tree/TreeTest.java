package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Test class Tree.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 07.02.2018
 */
public class TreeTest {
    @Test
    public void whenAddNewChildNodeToParentThenTrue() {
        Tree<Integer> tree = new Tree<>(1);
        assertTrue(tree.add(1, 2));
    }

    @Test
    public void whenAddNodeThatAlreadyExistThenFalse() {
        Tree<Integer> tree = new Tree<>(1);
        assertFalse(tree.add(1, 1));
    }

    @Test
    public void whenAddNodeToParentWhichNotExistThenFalse() {
        Tree<Integer> tree = new Tree<>(1);
        assertFalse(tree.add(2, 3));
    }

    @Test
    public void whenCreateTreeThenHasNextOnceTrue() {
        Iterator<Node<Integer>> nodes = new Tree<>(1).iterator();
        assertTrue(nodes.hasNext());
    }

    @Test
    public void whenOneNodeAfterNextHasNextReturnFalse() {
        Iterator<Node<Integer>> nodes = new Tree<>(1).iterator();
        nodes.next();
        assertFalse(nodes.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenOneNodeSecondNextThrowException() {
        Iterator<Node<Integer>> nodes = new Tree<>(1).iterator();
        nodes.next();
        nodes.next();
    }

    @Test
    public void whenTreeHasNodeSixThenFindByValueSixReturnOptionWithThisNode() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertTrue(tree.findBy(6).isPresent());
    }

    @Test
    public void whenFindByNodeValueThatNotExistThenReturnEmptyOption() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertFalse(tree.findBy(7).isPresent());
    }

    @Test
    public void whenEachNodeOfTheTreeHasLessThenThreeChildThenTreeIsBinary() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        assertTrue(tree.isBinary());
    }

    @Test
    public void whenSomeNodeOfTheTreeHasMoreThanTwoChildThenTreeIsNotBinary() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        assertFalse(tree.isBinary());
    }
}
