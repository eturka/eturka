package ru.job4j.loop;

/**
 * Class Factorial вычисляет факториал.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 14.10.2017
 */
public class Factorial {
    /**
     * Возвращает факториал заданного числа.
     *
     * @param n неотрицательное целое число
     * @return int факториал
     */
    public int calc(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
