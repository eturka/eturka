package ru.job4j.tracker;

/**
 * Interface Input.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 12.11.2017
 */
public interface Input {
    /**
     * Ask question and return an answer.
     *
     * @param question the question for user
     * @return answer
     */
    String ask(String question);
}