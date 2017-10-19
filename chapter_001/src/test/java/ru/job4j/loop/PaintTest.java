package ru.job4j.loop;

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
public class PaintTest {
    /**
     * Test board.
     */
    @Test
    public void whenHeightIsTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        final String eol = System.lineSeparator();
        String expected = String.format(" ^ %s^^^%s", eol, eol);
        assertThat(result, is(expected));
    }

    /**
     * Test board.
     */
    @Test
    public void whenHeightIsThreeThenStringWithThreeRows() {
        Paint paint = new Paint();
        String result = paint.piramid(3);
        final String eol = System.lineSeparator();
        String expected = String.format("  ^  %s ^^^ %s^^^^^%s", eol, eol, eol);
        assertThat(result, is(expected));
    }
}
