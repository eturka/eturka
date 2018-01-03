package ru.job4j.bank;

import java.util.Objects;

/**
 * Class User.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 03.01.2018
 */
public class User {
    /**
     * Passport number (unique user identifier).
     */
    private final String passport;
    /**
     * User name.
     */
    private final String name;

    /**
     * Create User with base information.
     *
     * @param passport passport number
     */
    public User(String passport) {
        this(passport, "");
    }

    /**
     * Create User with general information.
     *
     * @param passport passport number
     * @param name     user name
     */
    public User(String passport, String name) {
        this.name = name;
        this.passport = passport;
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
        return Objects.equals(passport, user.passport);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
