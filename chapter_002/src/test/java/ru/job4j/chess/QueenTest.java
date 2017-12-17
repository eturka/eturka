package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class Queen.
 *
 * @author Ekaterina Turka (mailto:ekaterina2rka@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class QueenTest {
    /**
     * Can make random count diagonal, horizontal or vertical steps.
     *
     * @throws ImpossibleMoveException if figure can't make step
     */
    @Test
    public void countSteps() throws ImpossibleMoveException {
        Queen queen = new Queen(new Cell(0, 0));
        assertThat(queen.countSteps(new Cell(2, 0)), is(2));
        assertThat(queen.countSteps(new Cell(0, 2)), is(2));
        assertThat(queen.countSteps(new Cell(2, 2)), is(2));
    }

    /**
     * Test two steps vertically.
     *
     * @throws ImpossibleMoveException if figure can't make step
     */
    @Test
    public void way() throws ImpossibleMoveException {
        Cell[] steps = new Cell[]{new Cell(1, 0), new Cell(2, 0), new Cell(3, 0)};
        Queen queen = new Queen(steps[0]);
        assertArrayEquals(queen.way(steps[2]), steps);
    }

    /**
     * Check that copy return queen with dest position.
     */
    @Test
    public void copy() {
        Queen queen = new Queen(new Cell(0, 0));
        Cell dest = new Cell(1, 1);
        Queen except = new Queen(dest);
        assertEquals(queen.copy(dest), except);
    }
}