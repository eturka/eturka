package ru.job4j.sort;

import java.util.Objects;

/**
 * Class User.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 29.12.2017
 */
public class User implements Comparable<User> {
    /**
     * User name.
     */
    private final String name;
    /**
     * User age.
     */
    private final int age;

    /**
     * Create user with name and age.
     *
     * @param name user name
     * @param age  user age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
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
        return age == user.age
                && Objects.equals(name, user.name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }
}
