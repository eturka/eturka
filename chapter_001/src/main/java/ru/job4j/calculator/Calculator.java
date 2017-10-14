package ru.job4j.calculator;

/**
 * Class Calculator производит простейшие арифметические операции с двумя аргументами.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 14.10.2017
 */
public class Calculator {
    /**
     * Результат вычислений.
     */
    private double result;

    /**
     * Вычисление суммы двух аргументов.
     *
     * @param first  слогаемое
     * @param second слогаемое
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Вычисление разности двух аргументов.
     *
     * @param first  уменьшаемое
     * @param second вычитаемое
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Вычисление отношения двух аргументов.
     *
     * @param first  делимое
     * @param second делитель
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Вычисление произведения двух аргументов.
     *
     * @param first  множитель
     * @param second множитель
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Возвращает результат вычислений.
     *
     * @return double
     */
    public double getResult() {
        return this.result;
    }
}
