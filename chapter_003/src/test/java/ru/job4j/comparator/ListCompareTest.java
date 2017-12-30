package ru.job4j.comparator;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test ListCompare.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 30.12.2017
 */
public class ListCompareTest {
    /**
     * Test when left and right are equals, than method compare return 0.
     */
    @Test
    public void whenLeftAndRightEqualsThenZero() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3)
        );
        assertThat(rst, is(0));
    }

    /**
     * Test when left is smaller than right, than method compare return -1.
     */
    @Test
    public void whenLeftLessRightThenMinus() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1),
                Arrays.asList(1, 2, 3)
        );
        assertThat(rst, is(-1));
    }

    /**
     * Test when left is greater than right, than method compare return 1.
     */
    @Test
    public void whenLeftGreatRightThenPlus() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1, 2),
                Arrays.asList(1, 1)
        );
        assertThat(rst, is(1));
    }
}