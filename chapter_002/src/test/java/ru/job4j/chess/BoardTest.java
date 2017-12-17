package ru.job4j.chess;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class Board.
 *
 * @author Ekaterina Turka (mailto:ekaterina2rka@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BoardTest {
    /**
     * If try to take figure from empty cell throw FigureNotFoundException.
     *
     * @throws FigureNotFoundException if cell is empty or out of boundaries
     */
    @Test(expected = FigureNotFoundException.class)
    public void take() throws FigureNotFoundException {
        Board board = new Board();
        board.take(new Cell(0, 0));
    }

    /**
     * Test addition figure on the board.
     *
     * @throws ImpossibleMoveException if can't add figure on that position
     */
    @Test
    public void addFigure() throws ImpossibleMoveException {
        Board board = new Board();
        Cell source = new Cell(0, 0);
        Figure bishop = new Bishop(source);
        board.addFigure(bishop);
        assertEquals(board.take(source), bishop);
    }

    /**
     * Test movement figure on the board.
     *
     * @throws ImpossibleMoveException if move is impossible
     */
    @Test
    public void move() throws ImpossibleMoveException {
        Board board = new Board();
        Cell source = new Cell(0, 0);
        Cell dest = new Cell(1, 1);
        Figure bishop = new Bishop(source);
        board.addFigure(bishop);
        board.move(source, dest);
        assertEquals(board.take(dest), new Bishop(dest));
    }
}