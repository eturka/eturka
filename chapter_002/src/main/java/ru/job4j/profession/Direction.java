package ru.job4j.profession;

/**
 * Class Direction contain information about professional direction.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 26.10.2017
 */
public abstract class Direction {
    /**
     * Direction name.
     */
    private String name;

    /**
     * Initialize a professional direction by name.
     *
     * @param name direction name
     */
    public Direction(String name) {
        this.name = name;
    }

    /**
     * @return the name of the direction
     */
    public String getName() {
        return name;
    }
}
