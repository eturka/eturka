package ru.job4j.chess;

import java.util.Scanner;

/**
 * Class Input.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 12.11.2017
 */
public class Input {
    /**
     * Scanner type.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Ask question and return an answer.
     *
     * @param question the question for user
     * @return answer
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}