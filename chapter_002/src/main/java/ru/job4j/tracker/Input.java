package ru.job4j.tracker;

/**
 * Abstract class Input.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 12.11.2017
 */
public abstract class Input {
    /**
     * Ask question and return an answer.
     *
     * @param question the question for user
     * @return answer
     */
    abstract String ask(String question);

    /**
     * Ask question and return an answer.
     *
     * @param question the question for user
     * @param range    array of correct keys
     * @return key
     */
    public int ask(String question, int[] range) {
        int answer = Integer.valueOf(this.ask(question));
        for (int key : range) {
            if (key == answer) {
                return answer;
            }
        }
        throw new MenuOutException("Key \"" + answer + "\" is out of range.");
    }
}