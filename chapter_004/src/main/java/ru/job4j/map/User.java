package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

/**
 * Class User.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 28.01.2018
 */
public class User {
    /**
     * User name.
     */
    private final String name;
    /**
     * User date of birth.
     */
    private final Calendar birthday;
    /**
     * Count of children.
     */
    private final int children;

    /**
     * Create user with base params.
     *
     * @param name     user name
     * @param birthday date of birth
     * @param children count of children
     */
    public User(String name, Calendar birthday, int children) {
        this.name = name;
        this.birthday = birthday;
        this.children = children;
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
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }
}
