package ru.job4j.user;

import java.util.Objects;

/**
 * Class User.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 29.12.2017
 */
public class User {
    /**
     * User identifier.
     */
    private final int id;
    /**
     * User name.
     */
    private final String name;
    /**
     * User location.
     */
    private final String city;

    /**
     * @param id   identifier
     * @param name of user
     * @param city location of user
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * @return User identifier
     */
    public int getId() {
        return id;
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
        User user = (User) o;
        return id == user.id
                && Objects.equals(name, user.name)
                && Objects.equals(city, user.city);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }
}
