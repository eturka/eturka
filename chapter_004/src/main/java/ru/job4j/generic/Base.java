package ru.job4j.generic;

/**
 * Class Base.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 13.01.2018
 */
public abstract class Base {
    /**
     * Identifier.
     */
    private final String id;

    /**
     * Create object with identifier.
     *
     * @param id identifier
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * @return identifier
     */
    public String getId() {
        return id;
    }
}
