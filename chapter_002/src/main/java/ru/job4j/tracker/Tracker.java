package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Tracker.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 02.11.2017
 */
public class Tracker {
    private List<Item> items = new ArrayList<>();

    /**
     * Addition.
     *
     * @param item some new item
     * @return new item with id
     */
    public Item add(Item item) {
        item.setId(String.valueOf(item.hashCode()));
        items.add(item);
        return item;
    }

    /**
     * Update.
     *
     * @param patch container with new information about item
     * @throws IllegalArgumentException when you try to update item that not exist
     */
    public void update(Item patch) {
        Item item = findById(patch.getId());
        if (item == null) {
            throw new IllegalArgumentException("Can't update, item wasn't found!");
        }
        item.setName(patch.getName());
        item.setDesc(patch.getDesc());
        item.setCreated(patch.getCreated());
        item.setComments(patch.getComments());
    }


    /**
     * Delete.
     *
     * @param id container with information about item that you need to delete
     * @throws IllegalArgumentException when you try to delete item that not exist
     */
    public void delete(String id) {
        Item item = findById(id);
        if (item == null) {
            throw new IllegalArgumentException("Can't delete, item wasn't found!");
        }
        this.items.remove(item);
    }

    /**
     * Getter for items.
     *
     * @return list of items
     */
    public Item[] findAll() {
        return this.items.toArray(new Item[items.size()]);
    }


    /**
     * Search items by name.
     *
     * @param name item name
     * @return list of items with the same name
     * @throws IllegalArgumentException when you try to search by null name
     */
    public Item[] findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Item name can't be null!");
        }
        List<Item> find = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(name)) {
                find.add(item);
            }
        }
        return find.toArray(new Item[find.size()]);
    }


    /**
     * Search item by id.
     *
     * @param id item identifier
     * @return founded item | null
     * @throws IllegalArgumentException when you try to search by null identifier
     */
    public Item findById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Item id can't be null!");
        }
        Item find = null;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                find = item;
                break;
            }
        }
        return find;
    }
}