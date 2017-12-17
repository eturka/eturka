package ru.job4j.chess;

/**
 * Class King.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 11.12.2017
 */
public class King extends Figure {
    /**
     * Create the figure on a board.
     *
     * @param position start position on a board
     */
    public King(Cell position) {
        super(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countSteps(Cell dest) throws ImpossibleMoveException {
        int x = Math.abs(dest.getX() - position.getX());
        int y = Math.abs(dest.getY() - position.getY());
        if (x > 1 || y > 1) {
            throw new ImpossibleMoveException();
        }
        return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Figure copy(Cell dest) {
        return new King(dest);
    }
}
