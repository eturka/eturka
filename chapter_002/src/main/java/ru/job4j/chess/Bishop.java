package ru.job4j.chess;

/**
 * Class Bishop.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 02.12.2017
 */
public class Bishop extends Figure {
    /**
     * Create the bishop on a board.
     *
     * @param position start position on the board
     */
    public Bishop(Cell position) {
        super(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countSteps(Cell dest) throws ImpossibleMoveException {
        if (Math.abs(dest.getX() - position.getX()) != Math.abs(dest.getY() - position.getY())) {
            throw new ImpossibleMoveException();
        }
        return Math.abs(dest.getX() - position.getX());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
