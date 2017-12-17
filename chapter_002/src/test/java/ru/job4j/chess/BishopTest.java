package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class Bishop.
 *
 * @author Ekaterina Turka (mailto:ekaterina2rka@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopTest {
    /**
     * Can make random count but only diagonal steps.
     *
     * @throws ImpossibleMoveException if figure can't make step
     */
    @Test
    public void countSteps() throws ImpossibleMoveException {
        Bishop bishop = new Bishop(new Cell(0, 2));
        assertThat(bishop.countSteps(new Cell(2, 4)), is(2));
    }

    /**
     * Test two steps diagonal.
     *
     * @throws ImpossibleMoveException if figure can't make step
     */
    @Test
    public void way() throws ImpossibleMoveException {
        Cell[] steps = new Cell[]{new Cell(0, 2), new Cell(1, 3), new Cell(2, 4)};
        Bishop bishop = new Bishop(steps[0]);
        assertArrayEquals(bishop.way(steps[2]), steps);
    }

    /**
     * Check that copy return bishop with dest position.
     */
    @Test
    public void copy() {
        Bishop bishop = new Bishop(new Cell(0, 0));
        Cell dest = new Cell(1, 1);
        Bishop except = new Bishop(dest);
        assertEquals(bishop.copy(dest), except);
    }
}