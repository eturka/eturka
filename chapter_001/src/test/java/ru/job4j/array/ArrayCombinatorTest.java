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
public class ArrayCombinatorTest {
    /**
     * Test array.
     */
    @Test
    public void whenOneFourAndOneTwoFiveThenOneOneTwoFourFive() {
        ArrayCombinator a = new ArrayCombinator();
        int[] result = a.combine(new int[]{1, 4}, new int[]{1, 2, 5});
        int[] expected = {1, 1, 2, 4, 5};
        assertThat(result, is(expected));
    }
}
