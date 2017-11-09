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
    private static final String EXIT = "6";
    /**
     * Input type.
     */
    private ConsoleInput input = new ConsoleInput();
    /**
     * Item tracker.
     */
    private Tracker tracker = new Tracker();

    /**
     * Available actions for user.
     */
    private String[] actions = new String[]{
            "0. Add new Item",
            "1. Show all items",
            "2. Edit item",
            "3. Delete item",
            "4. Find item by Id",
            "5. Find items by name",
            "6. Exit Program"
    };

    /**
     * Add and print new item.
     */
    private void addNewItem() {
        String name = input.ask("Insert your name: ");
        String desc = input.ask("Insert item description: ");
        Item item = new Item(name, desc, System.currentTimeMillis());
        System.out.println(tracker.add(item));
    }

    /**
     * Print all tracker's items.
     */
    private void showAllItems() {
        System.out.println("Items list:");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
    }

    /**
     * Update item.
     */
    private void editItem() {
        String id = input.ask("Insert item identifier: ");
        String name = input.ask("Insert your name: ");
        String desc = input.ask("Insert item description: ");
        Item item = new Item(name, desc, System.currentTimeMillis());
        item.setId(id);
        tracker.update(item);
        System.out.println("Item was updated!");
    }

    /**
     * Delete item.
     */
    private void deleteItem() {
        String id = input.ask("Insert item identifier: ");
        Item item = new Item(null, null, 0L);
        item.setId(id);
        tracker.delete(item);
        System.out.println("Item was deleted!");
    }

    /**
     * Find item by id.
     */
    private void findItemById() {
        String id = input.ask("Insert item identifier: ");
        System.out.println(tracker.findById(id));
    }

    /**
     * Find items by name.
     */
    private void findItemsByName() {
        String name = input.ask("Insert user name: ");
        for (Item item : tracker.findByName(name)) {
            System.out.println(item);
        }
    }


    /**
     * Print available actions list.
     */
    private void printActions() {
        for (String action : this.actions) {
            System.out.println(action);
        }
    }

    /**
     * Execute action.
     *
     * @param action some action's identifier from the actions
     */
    private void executeAction(String action) {
        switch (action) {
            case "0":
                addNewItem();
                break;
            case "1":
                showAllItems();
                break;
            case "2":
                editItem();
                break;
            case "3":
                deleteItem();
                break;
            case "4":
                findItemById();
                break;
            case "5":
                findItemsByName();
                break;
            default:
                System.out.println("Invalid action id: '" + action + "'!");
        }
    }

    /**
     * Main method of the program.
     */
    private void init() {
        while (true) {
            printActions();
            String answer = input.ask("Select: ");
            if (EXIT.equals(answer)) {
                System.exit(0);
            }
            try {
                executeAction(answer);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        StartUI startUI = new StartUI();
        startUI.init();
    }
}