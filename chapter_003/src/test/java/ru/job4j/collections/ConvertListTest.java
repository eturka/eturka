package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test class ConvertList.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 29.12.2017
 */
public class ConvertListTest {

    /**
     * Assert that if we change the 2d-array by toList we will get new list with the same elements in the same order.
     */
    @Test
    public void toList() {
        ConvertList convertList = new ConvertList();
        int[][] array = new int[][]{{1, 2, 3}, {4}};
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        assertEquals(convertList.toList(array), list);
    }

    /**
     * Assert that if we change list of 4 Integer by toArray with 3 rows, we will get 2D-array with the same order of
     * element and on the 5 and 6 positions it will have 0.
     */
    @Test
    public void toArray() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int[][] array = new int[][]{{1, 2, 3}, {4, 0, 0}};
        assertArrayEquals(convertList.toArray(list, 3), array);
    }

    /**
     * Assert that if we change list of two int arrays contains in summary three elements 1, 2, 3 by using convert
     * we will get new list of Integer contains same elements in the same order 1, 2, 3.
     */
    @Test
    public void convert() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1});
        list.add(new int[]{2, 3});
        List<Integer> except = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertEquals(convertList.convert(list), except);
    }
}