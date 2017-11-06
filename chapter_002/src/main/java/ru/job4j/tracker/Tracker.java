package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Class Tracker.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 02.11.2017
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int length = 0;

    /**
     * Addition.
     *
     * @param item some new item
     * @return new item with id
     */
    public Item add(Item item) {
        item.setId(String.valueOf(item.hashCode()));
        items[length++] = item;
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
     * @param item container with information about item that you need to delete
     * @throws IllegalArgumentException when you try to update item that not exist
     */
    public void delete(Item item) {
        int position = getPositionById(item.getId());
        if (position == length) {
            throw new IllegalArgumentException("Can't delete, item wasn't found!");
        }
        System.arraycopy(items, position + 1, items, position, length - position);
        length--;
    }

    /**
     * Getter for items.
     *
     * @return list of items
     */
    public Item[] findAll() {
        return this.items;
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
        Item[] temp = new Item[100];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (name.equals(this.items[i].getName())) {
                temp[count++] = this.items[i];
            }
        }
        return Arrays.copyOf(temp, count);
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
        for (int i = 0; i < length; i++) {
            if (id.equals(this.items[i].getId())) {
                find = this.items[i];
                break;
            }
        }
        return find;
    }

    /**
     * Search item position in array items.
     *
     * @param id itm identifier
     * @return position of item with id | items length if item wasn't found
     */
    private int getPositionById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Item id can't be null!");
        }
        int i;
        for (i = 0; i < length; i++) {
            if (id.equals(this.items[i].getId())) {
                break;
            }
        }
        return i;
    }
}