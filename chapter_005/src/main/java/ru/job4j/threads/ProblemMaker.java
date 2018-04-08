package ru.job4j.threads;

import java.util.Arrays;

/**
 * Class ProblemMaker show that when different threads use same object you cannot forecast result.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 08.04.2018
 */
public class ProblemMaker implements Runnable {

    private final int[] array;

    /**
     * Create new ProblemMaker with array to increase.
     *
     * @param array to increase
     */
    public ProblemMaker(final int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i]++;
        }
        System.out.println(Arrays.toString(this.array));
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            new Thread(new ProblemMaker(array)).start();
        }
    }
}
