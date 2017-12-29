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
    private int count;

    /**
     * Available actions for user.
     */
    private UserAction[] actions = new UserAction[7];

    /**
     * Print menu.
     */
    void print() {
        for (int i = 0; i < this.count; i++) {
            System.out.println(actions[i].info());
        }
    }

    /**
     * Fill menu by actions.
     */
    void fillActions() {
        this.addAction(new Add("Add new Item", 0));
        this.addAction(new ShowAll("Show all items", 1));
        this.addAction(new Edit("Edit item", 2));
        this.addAction(new Delete("Delete item", 3));
        this.addAction(new FindById("Find item by Id", 4));
        this.addAction(new FindByName("Find items by name", 5));
        this.addAction(new Exit("Exit tracker", EXIT));
    }

    /**
     * Add new action to menu.
     *
     * @param action new action
     */
    private void addAction(UserAction action) {
        this.actions[count++] = action;
    }

    /**
     * @return action keys array
     */
    int[] getKeys() {
        int[] keys = new int[this.count];
        for (int i = 0; i < this.count; i++) {
            keys[i] = this.actions[i].key();
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
    static class Exit extends BaseAction {
        /**
         * Create Exit with key and description.
         *
         * @param name information about action
         * @param key  action key
         */
        Exit(String name, int key) {
            super(name, key);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Bye!");
        }
    }

    /**
     * Add and print new item.
     */
    class Add extends BaseAction {
        /**
         * Create Add with key and description.
         *
         * @param name information about action
         * @param key  action key
         */
        Add(String name, int key) {
            super(name, key);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Insert your name: ");
            String desc = input.ask("Insert item description: ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            System.out.println(tracker.add(item).toString());
        }
    }

    /**
     * Print all tracker's items.
     */
    class ShowAll extends BaseAction {
        /**
         * Create ShowAll with key and description.
         *
         * @param name information about action
         * @param key  action key
         */
        ShowAll(String name, int key) {
            super(name, key);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Items list:");
            System.out.println(Arrays.toString(tracker.findAll()));
        }
    }

    /**
     * Update item.
     */
    static class Edit extends BaseAction {
        /**
         * Create Edit with key and description.
         *
         * @param name information about action
         * @param key  action key
         */
        Edit(String name, int key) {
            super(name, key);
        }

        /**
         * {@inheritDoc}
         */
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
    }

    /**
     * Delete item.
     */
    static class Delete extends BaseAction {
        /**
         * Create Delete with key and description.
         *
         * @param name information about action
         * @param key  action key
         */
        Delete(String name, int key) {
            super(name, key);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Insert item identifier: ");
            tracker.delete(id);
            System.out.println("Item was deleted!");
        }
    }
}

/**
 * Find item by id.
 */
class FindById extends BaseAction {
    /**
     * Create FindById with key and description.
     *
     * @param name information about action
     * @param key  action key
     */
    FindById(String name, int key) {
        super(name, key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Insert item identifier: ");
        Item item = tracker.findById(id);
        System.out.println(item);
    }
}

/**
 * Find items by name.
 */
class FindByName extends BaseAction {
    /**
     * Create FindByName with key and description.
     *
     * @param name information about action
     * @param key  action key
     */
    FindByName(String name, int key) {
        super(name, key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Insert user name: ");
        System.out.println(Arrays.toString(tracker.findByName(name)));
    }
}
