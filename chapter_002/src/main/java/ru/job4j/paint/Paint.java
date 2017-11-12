package ru.job4j.paint;

/**
 * Class Paint.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 12.11.2017
 */
public class Paint {
    /**
     * Draw shape in console.
     *
     * @param shape some shape
     */
    public void draw(Shape shape) {
        System.out.println(shape.pic());
    }
}
