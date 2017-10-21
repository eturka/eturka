package ru.job4j.array;

/**
 * Class SubString проверяет наличие подстроки в строке.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 19.10.2017
 */
class SubString {
    /**
     * Проверяет наличие подстроки в строке.
     *
     * @param origin базовая строка
     * @param sub    подстрока
     * @return принадлежит ли подстрока строке
     */
    boolean contains(String origin, String sub) {
        char[] o = origin.toCharArray();
        char[] s = sub.toCharArray();
        for (int i = 0; i < o.length; i++) {
            if (o[i] == s[0]) {
                int j = 1;
                while (j < s.length) {
                    if (o[i + j] != s[j]) {
                        break;
                    }
                    j++;
                }
                if (j == s.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
