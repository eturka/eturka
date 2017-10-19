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
public class BubbleSortTest {
    /**
     * Test sort.
     */
    @Test
    public void whenArrayFiveOneTwoSevenTreeThanOneTwoThreeFiveSeven() {
        BubbleSort bubble = new BubbleSort();
        int[] result = bubble.sort(new int[]{5, 1, 2, 7, 3});
        int[] expected = new int[]{1, 2, 3, 5, 7};
        assertThat(result, is(expected));
    }
}
