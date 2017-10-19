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
public class TurnTest {
    /**
     * Test turn.
     */
    @Test
    public void whenArrayOneTwoThenTwoOne() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[]{1, 2});
        int[] expected = new int[]{2, 1};
        assertThat(result, is(expected));
    }

    /**
     * Test turn.
     */
    @Test
    public void whenArrayOneTwoThreeThenThreeTwoOne() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[]{1, 2, 3});
        int[] expected = new int[]{3, 2, 1};
        assertThat(result, is(expected));
    }
}
