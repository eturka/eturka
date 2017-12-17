package ru.job4j.chess;

/**
 * Class Queen.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 11.12.2017
 */
public class Queen extends Figure {
    /**
     * Create the figure on a board.
     *
     * @param position start position on a board
     */
    public Queen(Cell position) {
        super(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countSteps(Cell dest) throws ImpossibleMoveException {
        int x = Math.abs(dest.getX() - position.getX());
        int y = Math.abs(dest.getY() - position.getY());
        if (x != y && x != 0 && y != 0) {
            throw new ImpossibleMoveException();
        }
        return x == 0 ? y : x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Figure copy(Cell dest) {
        return new Queen(dest);
    }
}
