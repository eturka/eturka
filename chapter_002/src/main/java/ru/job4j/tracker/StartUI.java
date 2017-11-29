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
    static final String EXIT = "exit";

    /**
     * Input type.
     */
    private Input input = new ConsoleInput();

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
        while (true) {
            menu.print();
            String answer = input.ask("Select action (or insert \"exit\" to quit program): ");
            if (EXIT.equals(answer)) {
                break;
            }
            try {
                int key = Integer.parseInt(answer);
                menu.getAction(key).execute(this.input, this.tracker);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid command: \"" + answer + "\"!");
            }
        }
    }

    public static void main(String[] args) {
        StartUI startUI = new StartUI();
        startUI.init();
        System.exit(0);
    }
}
