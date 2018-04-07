package ru.job4j.threads;

import java.io.FileReader;
import java.io.IOException;

/**
 * Class CountChar counts characters from the file while not interrupted.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 03.04.2018
 */
public class CountChar implements Runnable {
    @Override
    public void run() {
        int count = 0;
        try (FileReader reader = new FileReader("text.txt")) {
            int c = reader.read();
            while (c != -1 && !Thread.interrupted()) {
                System.out.print((char) c);
                c = reader.read();
                count++;
            }
            System.out.println();
            System.out.println("Counted characters: " + count);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
