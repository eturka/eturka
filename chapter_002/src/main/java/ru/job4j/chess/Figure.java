package ru.job4j.chess;

import java.util.Objects;

/**
 * Abstract class Figure.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 02.12.2017
 */
public abstract class Figure {
    /**
     * Figure's position on a board.
     */
    public final Cell position;

    /**
     * Create the figure on a board.
     *
     * @param position start position on a board
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Way of the figure to the destination.
     *
     * @param dest new position
     * @return cells that the figure use on the way to the destination
     * @throws ImpossibleMoveException if the figure can't follow the way to the destination
     */
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        int count = countSteps(dest);
        Cell[] steps = new Cell[count + 1];
        int horizontal = getDirection(position.getX(), dest.getX());
        int vertical = getDirection(position.getY(), dest.getY());
        steps[0] = position;
        steps[count] = dest;
        for (int i = 1; i < count; i++) {
            steps[i] = getStep(steps[i - 1], horizontal, vertical);
        }
        return steps;
    }

    /**
     * Create new step.
     *
     * @param previous   last step cell
     * @param horizontal step direction
     * @param vertical   step direction
     * @return new step
     */
    private Cell getStep(Cell previous, int horizontal, int vertical) {
        return new Cell(previous.getX() + horizontal, previous.getY() + vertical);
    }

    /**
     * Count necessary steps to reach the destination.
     *
     * @param dest new position
     * @return step's count between positions
     * @throws ImpossibleMoveException if the figure can't reach the destination from the source
     */
    public abstract int countSteps(Cell dest) throws ImpossibleMoveException;

    /**
     * Calculate step direction.
     *
     * @param source current position
     * @param dest   new position
     * @return step direction
     */
    private int getDirection(int source, int dest) {
        return Integer.signum(dest - source);
    }

    /**
     * Making figure copy on new position.
     *
     * @param dest new figure location
     * @return new figure located on dest position
     */
    public abstract Figure copy(Cell dest);

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Figure figure = (Figure) o;
        return Objects.equals(position, figure.position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
