package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

/**
 * Class Item.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 02.11.2017
 */
public class Item {
    /**
     * Identifier.
     */
    private String id;
    /**
     * Name.
     */
    private String name;
    /**
     * Description.
     */
    private String desc;
    /**
     * Created timestamp.
     */
    private long created;
    /**
     * Comments list.
     */
    private String[] comments;

    public Item() {
    }

    /**
     * @param name    name
     * @param desc    description
     * @param created timestamp
     */
    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return created == item.created
                && Objects.equals(id, item.id)
                && Objects.equals(name, item.name)
                && Objects.equals(desc, item.desc)
                && Arrays.equals(comments, item.comments);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, created, comments);
    }


    /**
     * @return short information about Item
     */
    @Override
    public String toString() {
        return "Identifier: " + (id != null ? id : "null")
                + " Name: " + (name != null ? name : "null")
                + " Description: " + (desc != null ? desc : "null")
                + " Created: " + String.valueOf(created);
    }
}
