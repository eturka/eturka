package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Class MenuTracker.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 29.11.2017
 */
class MenuTracker {
    /**
     * Action identifier to exit from the program.
     */
    static final int EXIT = 6;

    /**
     * Count of available actions.
     */
    private static final int ACTIONS_COUNT = 7;

    /**
     * Available actions for user.
     */
    private UserAction[] actions = new UserAction[]{
            new Add(),
            new ShowAll(),
            new Edit(),
            new Delete(),
            new FindById(),
            new FindByName(),
            new Exit()
    };

    /**
     * Print menu.
     */
    void print() {
        for (UserAction action : this.actions) {
            System.out.println(action.key() + ". " + action.info());
        }
    }

    /**
     * @return action keys array
     */
    int[] getKeys() {
        int[] keys = new int[ACTIONS_COUNT];
        int i = 0;
        for (UserAction action : this.actions) {
            keys[i++] = action.key();
        }
        return keys;
    }

    /**
     * Return action by key.
     *
     * @param key action identifier
     * @return action
     * @throws MenuOutException if key is out of bound
     */
    UserAction getAction(int key) {
        for (UserAction action : actions) {
            if (action.key() == key) {
                return action;
            }
        }
        throw new MenuOutException("Class Menu does not contain action with such key.");
    }


    /**
     * Exit program.
     */
    static class Exit implements UserAction {
        @Override
        public int key() {
            return EXIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Bye!");
        }

        @Override
        public String info() {
            return "Exit tracker";
        }
    }

    /**
     * Add and print new item.
     */
    class Add implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Insert your name: ");
            String desc = input.ask("Insert item description: ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            System.out.println(tracker.add(item).toString());
        }

        @Override
        public String info() {
            return "Add new Item";
        }
    }

    /**
     * Print all tracker's items.
     */
    class ShowAll implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Items list:");
            System.out.println(Arrays.toString(tracker.findAll()));
        }

        @Override
        public String info() {
            return "Show all items";
        }
    }

    /**
     * Update item.
     */
    static class Edit implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Insert item identifier: ");
            String name = input.ask("Insert your name: ");
            String desc = input.ask("Insert item description: ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            item.setId(id);
            tracker.update(item);
            System.out.println("Item was updated!");
        }

        @Override
        public String info() {
            return "Edit item";
        }
    }

    /**
     * Delete item.
     */
    static class Delete implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Insert item identifier: ");
            Item item = new Item();
            item.setId(id);
            tracker.delete(item);
            System.out.println("Item was deleted!");
        }

        @Override
        public String info() {
            return "Delete item";
        }
    }
}

/**
 * Find item by id.
 */
class FindById implements UserAction {

    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Insert item identifier: ");
        Item item = tracker.findById(id);
        System.out.println(item);
    }

    @Override
    public String info() {
        return "Find item by Id";
    }
}

/**
 * Find items by name.
 */
class FindByName implements UserAction {

    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Insert user name: ");
        System.out.println(Arrays.toString(tracker.findByName(name)));
    }

    @Override
    public String info() {
        return "Find items by name";
    }
}
