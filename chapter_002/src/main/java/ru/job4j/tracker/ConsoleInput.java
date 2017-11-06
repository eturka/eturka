package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class ConsoleInput.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 06.11.2017
 */
public class ConsoleInput {
    /**
     * Scanner type.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Ask question and return an answer.
     * @param question the question for user
     * @return answer
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
