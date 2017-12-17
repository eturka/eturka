package ru.job4j.chess;

import java.util.Objects;

/**
 * Class Cell.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 02.12.2017
 */
public class Cell {
    /**
     * Line number.
     */
    private int x;
    /**
     * Column number.
     */
    private int y;

    /**
     * Create the cell on the board.
     *
     * @param x line number
     * @param y column number
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return cell's line number
     */
    public int getX() {
        return x;
    }

    /**
     * @return cell's column number
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;
        return x == cell.x
                && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
