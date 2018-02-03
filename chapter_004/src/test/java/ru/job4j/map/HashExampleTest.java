package ru.job4j.map;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Class HashExample.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 03.02.2018
 */
public class HashExampleTest {
    @Test
    public void whenDifferentObjectsThenNotEquals() {
        int[] arr = {1, 2};
        HashExample example = new HashExample(true, 'a', 1, 1L, 1.0D, arr, "obj");
        HashExample different = new HashExample(true, 'a', 1, 1L, 1.0D, arr, null);
        assertNotEquals(example, different);
    }

    @Test
    public void whenSameObjectThenEquals() {
        int[] arr = {1, 2};
        HashExample example = new HashExample(true, 'a', 1, 1L, 1.0D, arr, "obj");
        assertEquals(example, example);
    }

    @Test
    public void whenSameObjectThenSameHash() {
        int[] arr = {1, 2};
        HashExample example = new HashExample(true, 'a', 1, 1L, 1.0D, arr, "obj");
        assertThat(example.hashCode(), is(example.hashCode()));
    }

    @Test
    public void whenEquivalentObjectsThenEquals() {
        int[] arr = {1, 2};
        HashExample example = new HashExample(true, 'a', 1, 1L, 1.0D, arr, "obj");
        HashExample equivalent = new HashExample(true, 'a', 1, 1L, 1.0D, arr, "obj");
        assertEquals(example, equivalent);
    }

    @Test
    public void whenEqualsThenSameHashes() {
        int[] arr = {1, 2};
        HashExample example = new HashExample(true, 'a', 1, 1L, 1.0D, arr, "obj");
        HashExample equivalent = new HashExample(true, 'a', 1, 1L, 1.0D, arr, "obj");
        assertThat(example.hashCode(), is(equivalent.hashCode()));
    }
}
