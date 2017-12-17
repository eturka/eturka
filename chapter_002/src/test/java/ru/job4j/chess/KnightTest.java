package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class Knight.
 *
 * @author Ekaterina Turka (mailto:ekaterina2rka@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class KnightTest {
    /**
     * Can make only one step to two cells by vertical|horizontal and one cell by horizontal|vertical.
     *
     * @throws ImpossibleMoveException if figure can't make step
     */
    @Test
    public void countSteps() throws ImpossibleMoveException {
        Knight knight = new Knight(new Cell(0, 1));
        assertThat(knight.countSteps(new Cell(1, 3)), is(1));
        assertThat(knight.countSteps(new Cell(2, 2)), is(1));
    }

    /**
     * Knight can make only one(count) step.
     *
     * @throws ImpossibleMoveException if figure can't make step
     */
    @Test
    public void way() throws ImpossibleMoveException {
        Cell[] steps = new Cell[]{new Cell(0, 1), new Cell(1, 3)};
        Knight knight = new Knight(steps[0]);
        assertArrayEquals(knight.way(steps[1]), steps);
    }

    /**
     * Check that copy return knight with dest position.
     */
    @Test
    public void copy() {
        Knight knight = new Knight(new Cell(0, 0));
        Cell dest = new Cell(1, 2);
        Knight except = new Knight(dest);
        assertEquals(knight.copy(dest), except);
    }
}