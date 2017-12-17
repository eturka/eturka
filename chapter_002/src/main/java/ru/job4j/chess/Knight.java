package ru.job4j.chess;

/**
 * Class Knight.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 11.12.2017
 */
public class Knight extends Figure {
    /**
     * Create the figure on a board.
     *
     * @param position start position on a board
     */
    public Knight(Cell position) {
        super(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countSteps(Cell dest) throws ImpossibleMoveException {
        int x = Math.abs(dest.getX() - position.getX());
        int y = Math.abs(dest.getY() - position.getY());
        if ((x == 2 && y == 1) || (y == 2 && x == 1)) {
            return 1;
        }
        throw new ImpossibleMoveException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Figure copy(Cell dest) {
        return new Knight(dest);
    }
}
