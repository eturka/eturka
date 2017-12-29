package ru.job4j.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ConvertList gives possibilities to covert 2D-array to list and back.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 29.12.2017
 */
public class ConvertList {

    /**
     * Create List from array with the same order of elements.
     *
     * @param array 2D-array of int elements
     * @return List of Integer
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] line : array) {
            for (int value : line) {
                list.add(value);
            }
        }
        return list;
    }

    /**
     * Create 2D-array from the list, with width = rows and the same order of the elements.
     * If count of list elements don't divide on r
     *
     * @param list List of Integer
     * @param rows count of columns in array
     * @return 2D-array of int
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int count = list.size(), lines = count / rows + (count % rows > 0 ? 1 : 0);
        int[][] array = new int[lines][rows];
        int row = 0, line = 0;
        for (Integer value : list) {
            if (row < rows) {
                array[line][row++] = value;
            } else {
                row = 0;
                array[++line][row++] = value;
            }
        }
        return array;
    }
}