package ru.job4j.set;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class SetContainer.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 27.01.2018
 */
public class SetContainerTest {
    @Test
    public void whenAddNewValueThenTrue() {
        SetContainer<String> container = new SetContainer<>();
        String value = "value", newValue = "newValue";
        assertTrue(container.add(value));
        assertTrue(container.add(newValue));
    }

    @Test
    public void whenAddNullValueThenFalse() {
        SetContainer<String> container = new SetContainer<>();
        String value = null;
        assertFalse(container.add(value));
    }

    @Test
    public void whenAddSameValueThenFalse() {
        SetContainer<String> container = new SetContainer<>();
        String value = "value", sameValue = "value";
        container.add(value);
        assertFalse(container.add(sameValue));
    }

    @Test
    public void whenRemoveAddedValueThenTrue() {
        SetContainer<String> container = new SetContainer<>();
        String value = "value";
        container.add(value);
        assertTrue(container.remove(value));
    }

    @Test
    public void whenRemoveNullValueThenFalse() {
        SetContainer<String> container = new SetContainer<>();
        String value = null;
        assertFalse(container.remove(value));
    }

    @Test
    public void whenRemoveNotExistValueThenFalse() {
        SetContainer<String> container = new SetContainer<>();
        String value = "notExist";
        assertFalse(container.remove(value));
    }

    @Test
    public void whenDoubleRemoveValueThenSecondFalse() {
        SetContainer<String> container = new SetContainer<>();
        String value = "value";
        container.add(value);
        container.remove(value);
        assertFalse(container.remove(value));
    }

    @Test
    public void whenContainsAddedValueThenTrue() {
        SetContainer<String> container = new SetContainer<>();
        String value = "value";
        container.add(value);
        assertTrue(container.contains(value));
    }

    @Test
    public void whenContainsNullValueThenFalse() {
        SetContainer<String> container = new SetContainer<>();
        String value = null;
        assertFalse(container.contains(value));
    }

    @Test
    public void whenContainsNotExistValueThenFalse() {
        SetContainer<String> container = new SetContainer<>();
        String value = "notExist";
        assertFalse(container.contains(value));
    }

    @Test
    public void whenDoubleContainsThenSameResult() {
        SetContainer<String> container = new SetContainer<>();
        String value = "value";
        assertEquals(container.contains(value), container.contains(value));
        container.add(value);
        assertEquals(container.contains(value), container.contains(value));
    }
}
