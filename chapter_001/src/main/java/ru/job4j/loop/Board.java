package ru.job4j.loop;

/**
 * Class Board рисует шахматную доску в псевдографике.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 14.10.2017
 */
public class Board {
    /**
     * Возвращает строку содержащую шахматную доску в псевдографике заданного размера.
     *
     * @param width  ширина доски
     * @param height высота доски
     * @return доска
     */
    public String paint(int width, int height) {
        StringBuilder sbPaint = new StringBuilder();
        final String eol = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            int even = i % 2;
            for (int j = 1; j <= width; j++) {
                sbPaint.append(j % 2 == even ? ' ' : 'X');
            }
            sbPaint.append(eol);
        }
        return sbPaint.toString();
    }
}
