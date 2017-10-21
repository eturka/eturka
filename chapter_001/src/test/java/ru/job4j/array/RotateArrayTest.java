package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Ekaterina Turka (mailto:ekaterina2rka@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RotateArrayTest {
    /**
     * Test rotate.
     */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        RotateArray array = new RotateArray();
        int[][] result = array.rotate(new int[][]{{1, 2}, {3, 4}});
        int[][] expected = new int[][]{{3, 1}, {4, 2}};
        assertThat(result, is(expected));
    }

    /**
     * Test rotate.
     */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        RotateArray array = new RotateArray();
        int[][] result = array.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        int[][] expected = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(result, is(expected));
    }
}
