package ru.job4j.chess;

/**
 * Class Board.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 02.12.2017
 */
public class Board {
    /**
     * Count of the cells on the line.
     */
    public static final int WIDTH = 8;
    /**
     * Count of the cells on the column.
     */
    public static final int HEIGHT = 8;

    /**
     * Figures on the board.
     */
    private final Figure[][] figures = new Figure[WIDTH][HEIGHT];

    /**
     * Take figure from the boards cell if it is possible.
     *
     * @param source figure location cell
     * @return figure from the source cell
     * @throws FigureNotFoundException if there are no figure on the cell or source cell is out of bord boundaries
     */
    public Figure take(Cell source) throws FigureNotFoundException {
        if (source == null || emptyCell(source.getX(), source.getY())) {
            throw new FigureNotFoundException();
        }
        return this.figures[source.getX()][source.getY()];
    }

    /**
     * Make move on the board if it is possible.
     *
     * @param source cell with the figure
     * @param dest   new figure position
     * @throws ImpossibleMoveException when command break the rules
     * @throws OccupiedWayException    when try to use the way which occupied by another figure
     * @throws FigureNotFoundException when try to take a figure from the empty cell
     */
    public void move(Cell source, Cell dest) throws ImpossibleMoveException {
        if (source.equals(dest)) {
            throw new ImpossibleMoveException();
        }
        Figure figure = take(source);
        if (!isFree(figure.way(dest))) {
            throw new OccupiedWayException();
        }
        figures[dest.getX()][dest.getY()] = figure.copy(dest);
        figures[source.getX()][source.getY()] = null;
    }

    /**
     * Check if the way is free.
     *
     * @param steps array of steps that figure has to make
     * @return true if the way id free or false if something hinders
     */
    private boolean isFree(Cell[] steps) {
        boolean free = true;
        for (int i = 1; i < steps.length; i++) {
            if (figures[steps[i].getX()][steps[i].getY()] != null) {
                free = false;
                break;
            }
        }
        return free;
    }

    /**
     * Add new figure to its position on the board.
     *
     * @param figure new chess figure
     * @throws ImpossibleMoveException if field is not empty or not on the board
     */
    public void addFigure(Figure figure) throws ImpossibleMoveException {
        Cell cell = figure.position;
        int x = cell.getX();
        int y = cell.getY();
        if (!emptyCell(x, y)) {
            throw new ImpossibleMoveException();
        }
        figures[x][y] = figure;
    }

    /**
     * Check if boards cell is empty.
     *
     * @param x line number
     * @param y column number
     * @return true if field is empty and locate on the board
     */
    private boolean emptyCell(int x, int y) {
        return x >= 0 && y >= 0
                && x < WIDTH && y < HEIGHT
                && figures[x][y] == null;
    }
}
