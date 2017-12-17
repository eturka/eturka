package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class Pawn.
 *
 * @author Ekaterina Turka (mailto:ekaterina2rka@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PawnTest {
    /**
     * Can make only one step to the front, except it's on start position, than can make to steps to the front.
     *
     * @throws ImpossibleMoveException if figure can't make step
     */
    @Test
    public void countSteps() throws ImpossibleMoveException {
        Pawn pawn = new Pawn(new Cell(1, 0));
        assertThat(pawn.countSteps(new Cell(2, 0)), is(1));
        assertThat(pawn.countSteps(new Cell(3, 0)), is(2));
    }

    /**
     * Test two steps instance from the start position.
     *
     * @throws ImpossibleMoveException if figure can't make step
     */
    @Test
    public void way() throws ImpossibleMoveException {
        Cell[] steps = new Cell[]{new Cell(1, 0), new Cell(2, 0), new Cell(3, 0)};
        Pawn pawn = new Pawn(steps[0]);
        assertArrayEquals(pawn.way(steps[2]), steps);
    }

    /**
     * Check that copy return pawn with dest position.
     */
    @Test
    public void copy() {
        Pawn pawn = new Pawn(new Cell(1, 0));
        Cell dest = new Cell(2, 0);
        Pawn except = new Pawn(dest);
        assertEquals(pawn.copy(dest), except);
    }
} 