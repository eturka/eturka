package ru.job4j.tracker;

/**
 * Class BaseAction.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 02.12.2017
 */
public abstract class BaseAction implements UserAction {
    /**
     * Description of the action.
     */
    private String name;
    /**
     * Key of the action.
     */
    private int key;

    /**
     * Create BaseAction with key and description.
     *
     * @param name information about action
     * @param key  action key
     */
    BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
