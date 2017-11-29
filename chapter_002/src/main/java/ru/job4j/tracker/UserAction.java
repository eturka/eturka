package ru.job4j.tracker;

/**
 * Interface UserAction
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 20.11.2017
 */
public interface UserAction {
    /**
     * @return action identifier
     */
    int key();

    /**
     * @param input   type of input stream
     * @param tracker object with items
     */
    void execute(Input input, Tracker tracker);

    /**
     * @return information about the action
     */
    String info();
}
