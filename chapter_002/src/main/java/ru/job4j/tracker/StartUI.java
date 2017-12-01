package ru.job4j.tracker;

/**
 * Class StartUI.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 06.11.2017
 */
public class StartUI {
    /**
     * Action identifier to exit from the program.
     */
    static final int EXIT = MenuTracker.EXIT;

    /**
     * Input type.
     */
    private Input input = new ValidateInput();

    /**
     * Item tracker.
     */
    private Tracker tracker = new Tracker();

    /**
     * Default constructor whit console input and empty tracker.
     */
    private StartUI() {
    }

    /**
     * @param input   custom input
     * @param tracker some tracker
     */
    StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Main method of the program.
     */
    void init() {
        MenuTracker menu = new MenuTracker();
        int[] keys = menu.getKeys();
        while (true) {
            menu.print();
            int key = input.ask("Select action: ", keys);
            menu.getAction(key).execute(this.input, this.tracker);
            if (EXIT == key) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        StartUI startUI = new StartUI();
        startUI.init();
        System.exit(0);
    }
}
