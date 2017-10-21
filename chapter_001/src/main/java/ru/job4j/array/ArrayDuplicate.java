package ru.job4j.array;

import java.util.Arrays;

/**
 * Class ArrayDuplicate убирает дубликаты из массива.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 19.10.2017
 */
public class ArrayDuplicate {
    /**
     * Возвращает массив без дубликатов.
     *
     * @param array исходный массив
     * @return массив без дубликатов
     */
    public String[] remove(String[] array) {
        int n = array.length - 1;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j <= n) {
                if (array[i].equals(array[j])) {
                    array[j] = array[n];
                    n--;
                } else {
                    j++;
                }
            }
        }
        return Arrays.copyOf(array, n + 1);
    }
}
