package ru.job4j.loop;

/**
 * Class Pain строит пирамиду в псевдографике.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 19.10.2017
 */
public class Paint {
    /**
     * Возвращает строку содержащую пирамиду заданной высоты.
     *
     * @param h высота пирамиды
     * @return пирамида
     */
    public String piramid(int h) {
        StringBuilder piramid = new StringBuilder();
        String eol = System.lineSeparator();
        for (int i = 0; i < h; i++) {
            for (int j = 1; j < h * 2; j++) {
                if (j < h - i || j > h + i) {
                    piramid.append(' ');
                } else {
                    piramid.append('^');
                }
            }
            piramid.append(eol);
        }
        return piramid.toString();
    }
}
