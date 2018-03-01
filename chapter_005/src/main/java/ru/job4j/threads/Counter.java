package ru.job4j.threads;

/**
 * Class Counter.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 28.02.2018
 */
public class Counter {
    /**
     * Analyzed text.
     */
    private final char[] text;

    /**
     * Create counter with text for analyze.
     *
     * @param text for analyze
     */
    private Counter(final String text) {
        this.text = text.toCharArray();
    }

    /**
     * Count spaces in text.
     */
    private class Space implements Runnable {
        @Override
        public void run() {
            int count = 0;
            for (char symbol : text) {
                if (symbol == ' ') {
                    count++;
                }
            }
            System.out.println(String.format("Spaces: %s", count));
        }
    }

    /**
     * Count words in text.
     */
    private class Word implements Runnable {
        @Override
        public void run() {
            int count = 0;
            for (int i = 1; i < text.length; i++) {
                if (text[i] == ' ' && text[i - 1] != ' ') {
                    count++;
                }
            }
            if (text.length > 0 && text[text.length - 1] != ' ') {
                count++;
            }
            System.out.println(String.format("Words: %s", count));
        }
    }

    /**
     * Count spaces and words in the text.
     */
    private void count() {
        Thread general = Thread.currentThread(), space = new Thread(new Space()), word = new Thread(new Word());
        System.out.println(general.getName());
        space.start();
        word.start();
        try {
            space.join();
            word.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(general.getName());
    }

    public static void main(String[] args) {
        new Counter("Five words and four spaces").count();
    }
}
