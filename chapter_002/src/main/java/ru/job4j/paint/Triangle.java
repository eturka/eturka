package ru.job4j.paint;

/**
 * Class Triangle.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 12.11.2017
 */
public class Triangle implements Shape {
    /**
     * Return triangle in string format.
     *
     * @return string with triangle
     */
    @Override
    public String pic() {
        StringBuilder triangle = new StringBuilder();
        triangle.append(" ^ ");
        triangle.append(System.lineSeparator());
        triangle.append("^^^");
        return triangle.toString();
    }
}
