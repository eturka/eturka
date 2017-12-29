package ru.job4j.sort;

import java.util.*;

/**
 * Class SortUser.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 29.12.2017
 */
public class SortUser {
    /**
     * Return Set contains users from list sorted by age in ascending order.
     *
     * @param list unsorted List of users
     * @return sorted set of users
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }
}
