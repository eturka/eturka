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
public class BoardTest {
    /**
     * Test board.
     */
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String eol = System.lineSeparator();
        String expected = String.format("X X%s X %sX X%s", eol, eol, eol);
        assertThat(result, is(expected));
    }

    /**
     * Test board.
     */
    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String result = board.paint(5, 4);
        final String eol = System.lineSeparator();
        String expected = String.format("X X X%s X X %sX X X%s X X %s", eol, eol, eol, eol);
        assertThat(result, is(expected));
    }
}
