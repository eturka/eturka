package ru.job4j.tracker;

/**
 * Class StubInput.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 12.11.2017
 */
public class StubInput extends Input {
    /**
     * Array of answers.
     */
    private String[] answers;

    /**
     * Answer position.
     */
    private int position = 0;

    /**
     * @param answers array of answers
     */
    StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Ask question and return an answer.
     *
     * @param question the question for user
     * @return answer
     */
    public String ask(String question) {
        if (this.position == this.answers.length) {
            throw new ArrayIndexOutOfBoundsException("You ask to many questions!");
        }
        return answers[position++];
    }
}
