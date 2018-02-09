package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class BinarySearchTree.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 09.02.2018
 */
public class BinarySearchTreeTest {
    @Test
    public void whenAddNewElementToTheTreeTheTrue() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(1);
        assertTrue(tree.add(2));
    }

    @Test
    public void whenAddElementThatAlreadyExistThenFalse() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(1);
        assertFalse(tree.add(1));
    }

    @Test
    public void whenCreateTreeThenCanFindRootElement() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(1);
        assertTrue(tree.find(1));
    }

    @Test
    public void whenCreateTreeThenCannotFindValueDifferentFromRoot() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(1);
        assertFalse(tree.find(2));
    }

    @Test
    public void whenAddTwoToTheTreeThenCanFindTwo() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(1);
        tree.add(2);
        assertTrue(tree.find(2));
    }

    @Test
    public void whenHasNextIfNextExistThenTrue() {
        Iterator<Integer> nodes = new BinarySearchTree<>(1).iterator();
        assertTrue(nodes.hasNext());
    }

    @Test
    public void whenHasNextIfNextNotExistThenFalse() {
        Iterator<Integer> nodes = new BinarySearchTree<>(1).iterator();
        nodes.next();
        assertFalse(nodes.hasNext());
    }

    @Test
    public void whenCreateTreeThenNextReturnRoot() {
        Iterator<Integer> nodes = new BinarySearchTree<>(1).iterator();
        assertThat(nodes.next(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenCreateTreeThenSecondNextThrowException() {
        Iterator<Integer> nodes = new BinarySearchTree<>(1).iterator();
        nodes.next();
        nodes.next();
    }

    @Test
    public void whenAddOneThreeTwoFourThenThirdNextReturnThree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(1);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        Iterator<Integer> nodes = tree.iterator();
        nodes.next();
        nodes.next();
        assertThat(nodes.next(), is(3));
    }

    @Test
    public void whenAddOneThreeTwoFourThenCanFindTwo() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(1);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        assertTrue(tree.find(2));
    }

    @Test
    public void whenAddTwoFourFiveOneThenCannotFindThree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(2);
        tree.add(4);
        tree.add(5);
        tree.add(1);
        assertFalse(tree.find(3));
    }
}