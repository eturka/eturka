package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class King.
 *
 * @author Ekaterina Turka (mailto:ekaterina2rka@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class KingTest {
    /**
     * Can make only one diagonal, horizontal or vertical step.
     *
     * @throws ImpossibleMoveException if figure can't make step
     */
    @Test
    public void countSteps() throws ImpossibleMoveException {
        King king = new King(new Cell(0, 0));
        assertThat(king.countSteps(new Cell(1, 0)), is(1));
        assertThat(king.countSteps(new Cell(0, 1)), is(1));
        assertThat(king.countSteps(new Cell(1, 1)), is(1));
    }

    /**
     * Test one step vertically.
     *
     * @throws ImpossibleMoveException if figure can't make step
     */
    @Test
    public void way() throws ImpossibleMoveException {
        Cell[] steps = new Cell[]{new Cell(1, 0), new Cell(2, 0)};
        King king = new King(steps[0]);
        assertArrayEquals(king.way(steps[1]), steps);
    }

    /**
     * Check that copy return king with dest position.
     */
    @Test
    public void copy() {
        King king = new King(new Cell(0, 0));
        Cell dest = new Cell(1, 1);
        King except = new King(dest);
        assertEquals(king.copy(dest), except);
    }
}