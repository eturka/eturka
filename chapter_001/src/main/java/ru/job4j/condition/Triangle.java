package ru.job4j.condition;

/**
 * Class Point проверяет положение точки.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 14.10.2017
 */

public class Triangle {
    /**
     * Первая вершина треугольника.
     */
    private Point a;
    /**
     * Вторая вершина треугольника.
     */
    private Point b;
    /**
     * Третяя вершина треугольника.
     */
    private Point c;

    /**
     * Инициализация вершин треугольника.
     *
     * @param a первая вершина треугольника
     * @param b вторая вершина треугольника
     * @param c третяя вершина треугольника
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод должен вычислять расстояние между точками left и right.
     * <p>
     * Для вычисления расстояния использовать формулу.
     * √(xb - xa)^2 + (yb - ya)^2
     * <p>
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     * <p>
     * ^ - степень.
     *
     * @param left  Точка слева
     * @param right Точка справа.
     * @return расстояние между точками left и right.
     */
    public double distance(Point left, Point right) {
        return Math.sqrt(Math.pow(right.getX() - left.getX(), 2) + Math.pow(right.getY() - left.getY(), 2));
    }

    /**
     * Метод вычисления периметра по длинам сторон.
     * <p>
     * Формула.
     * <p>
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return периметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод должен вычислить прощадь треугольканива.
     * <p>
     * Формула.
     * <p>
     * √ p *(p - ab) * (p - ac) * (p - bc)
     * <p>
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * @return Вернуть прощадь, если треугольник существует или -1.
     */
    public double area() {
        double rsl = -1;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * <p>
     * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return можно ли построить треугольник
     */
    private boolean exist(double ab, double ac, double bc) {
        return ab > 0 && ac > 0 && bc > 0;
    }
}