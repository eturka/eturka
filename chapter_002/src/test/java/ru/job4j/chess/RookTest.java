package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class Rook.
 *
 * @author Ekaterina Turka (mailto:ekaterina2rka@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RookTest {
    /**
     * Can make random count but only horizontal or vertical steps.
     *
     * @throws ImpossibleMoveException if figure can't make step
     */
    @Test
    public void countSteps() throws ImpossibleMoveException {
        Rook rook = new Rook(new Cell(0, 0));
        assertThat(rook.countSteps(new Cell(2, 0)), is(2));
        assertThat(rook.countSteps(new Cell(0, 2)), is(2));
    }

    /**
     * Test two steps vertically.
     *
     * @throws ImpossibleMoveException if figure can't make step
     */
    @Test
    public void way() throws ImpossibleMoveException {
        Cell[] steps = new Cell[]{new Cell(1, 0), new Cell(2, 0), new Cell(3, 0)};
        Rook rook = new Rook(steps[0]);
        assertArrayEquals(rook.way(steps[2]), steps);
    }

    /**
     * Check that copy return rook with dest position.
     */
    @Test
    public void copy() {
        Rook rook = new Rook(new Cell(0, 0));
        Cell dest = new Cell(0, 1);
        Rook except = new Rook(dest);
        assertEquals(rook.copy(dest), except);
    }
}