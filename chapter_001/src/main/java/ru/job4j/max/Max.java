package ru.job4j.max;

/**
 * Class Max позволяет получить максимальное из двух чисел.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 14.10.2017
 */
public class Max {
    /**
     * Возвращает максимальное из двух чисел.
     *
     * @param first  первое число
     * @param second второе число
     * @return int
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
