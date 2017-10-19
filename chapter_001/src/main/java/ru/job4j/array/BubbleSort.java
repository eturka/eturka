package ru.job4j.array;

/**
 * Class BubbleSort сортирует массив методом пузырька.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 19.10.2017
 */
public class BubbleSort {
    /**
     * Возвращает отсортированный массив.
     *
     * @param array исходный массив
     * @return упорядоченный массив
     */
    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
