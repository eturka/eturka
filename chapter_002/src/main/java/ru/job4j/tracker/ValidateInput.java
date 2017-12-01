package ru.job4j.tracker;

/**
 * Class ValidateInput.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 01.12.2017
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Ask question and return an answer.
     *
     * @param question the question for user
     * @param range    array of correct keys
     * @return key
     */
    public int ask(String question, int[] range) {
        do {
            try {
                return super.ask(question, range);
            } catch (MenuOutException e) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException e) {
                System.out.println("Please insert valid data.");
            }
        } while (true);
    }
}
