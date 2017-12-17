package ru.job4j.chess;

/**
 * Class Pawn.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 11.12.2017
 */
public class Pawn extends Figure {
    /**
     * Create the figure on a board.
     *
     * @param position start position on a board
     */
    public Pawn(Cell position) {
        super(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countSteps(Cell dest) throws ImpossibleMoveException {
        int x = dest.getX() - position.getX();
        int y = dest.getY() - position.getY();
        if (y == 0 && ((x == 2 && position.getX() == 1) || x == 1)) {
            return x;
        }
        throw new ImpossibleMoveException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Figure copy(Cell dest) {
        return new Pawn(dest);
    }
}
