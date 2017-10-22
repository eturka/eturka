package ru.job4j.array;

/**
 * Class ArrayCombinator составляет массив из двух отстортированных.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 22.10.2017
 */
class ArrayCombinator {
    /**
     * Создает массив из двух отсортированных.
     *
     * @param first  первый массив
     * @param second второй массив
     * @return итоговый массив
     */
    int[] combine(int[] first, int[] second) {
        int l = first.length - 1;
        int[] array = new int[l + second.length + 1];
        int fi = 0;
        int si = 0;
        for (int i = 0; i < array.length; i++) {
            if (fi > l || first[fi] > second[si]) {
                array[i] = second[si];
                si++;
            } else {
                array[i] = first[fi];
                fi++;
            }
        }
        return array;
    }
}
