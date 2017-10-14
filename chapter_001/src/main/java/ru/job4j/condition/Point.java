package ru.job4j.condition;

/**
 * Class Point проверяет положение точки.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 14.10.2017
 */
public class Point {
    /**
     * Координата точки на оси абсцисс.
     */
    private int x;
    /**
     * Координата точки на оси ординат.
     */
    private int y;

    /**
     * Конструктор. Задает положение точки на координатной плоскости.
     *
     * @param x координата на оси абсцисс
     * @param y координата на оси ординат
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату точки на оси абсцисс.
     *
     * @return int
     */
    public int getX() {
        return this.x;
    }

    /**
     * Возвращает координату точки на оси ординат.
     *
     * @return int
     */
    public int getY() {
        return this.y;
    }

    /**
     * Проверяет принадлежит ли тоска прямой.
     *
     * @param a угловой коэффициент
     * @param b смещение по оси ординат
     * @return boolean
     */
    public boolean is(int a, int b) {
        return a * this.x + b == this.y;
    }
}
