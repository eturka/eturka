package ru.job4j.paint;

/**
 * Class Square.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 12.11.2017
 */
public class Square implements Shape {
    /**
     * Return square in string format.
     *
     * @return string with square
     */
    @Override
    public String pic() {
        StringBuilder square = new StringBuilder();
        square.append("++");
        square.append(System.lineSeparator());
        square.append("++");
        return square.toString();
    }
}
