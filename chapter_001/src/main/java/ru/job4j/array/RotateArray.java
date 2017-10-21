package ru.job4j.array;

/**
 * Class RotateArray поворачивает квадратный массив по часовой стрелке.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 19.10.2017
 */
public class RotateArray {
    /**
     * Возвращает массив повернутый по часовой стрелке.
     *
     * @param array исходный квадратный массив
     * @return повернутый по часовой стрелке массив
     */
    public int[][] rotate(int[][] array) {
        int n = array.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - i; j++) {
                int temp = array[i][j];
                array[i][j] = array[n - j][i];
                array[n - j][i] = array[n - i][n - j];
                array[n - i][n - j] = array[j][n - i];
                array[j][n - i] = temp;
            }
        }
        return array;
    }
}
