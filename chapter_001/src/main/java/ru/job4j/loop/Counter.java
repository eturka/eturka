package ru.job4j.loop;

/**
 * Class Counter подсчетывает сумму чётных чисел в диапазоне.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 14.10.2017
 */
public class Counter {
    /**
     * Возвращает сумму чётных чисел в заданном диапазоне.
     *
     * @param start  начало диапазона
     * @param finish конец диапазона
     * @return int
     */
    public int add(int start, int finish) {
        int counter = 0;
        while (start <= finish) {
            if (start % 2 == 0) {
                counter += start;
            }
            start++;
        }
        return counter;
    }
}
