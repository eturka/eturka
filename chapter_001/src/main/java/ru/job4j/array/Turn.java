package ru.job4j.array;

/**
 * Class Turn переворачивает массив.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 19.10.2017
 */
public class Turn {
    /**
     * Возвращает перевернутый массив.
     *
     * @param array исходный массив
     * @return перевернутый массив
     */
    public int[] back(int[] array) {
        int length = array.length;
        int temp;
        for (int i = 0; i < length / 2; i++) {
            temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
        return array;
    }
}
