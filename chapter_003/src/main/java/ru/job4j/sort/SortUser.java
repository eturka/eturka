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
     * @param users unsorted List of users
     * @return sorted set of users
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * Return users list sorted by names length in ascending order.
     *
     * @param users unsorted list of users
     * @return users list sorted by name length
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                String o1Name = o1.getName(), o2Name = o2.getName();
                return Integer.compare(o1Name.length(), o2Name.length());
            }
        });
        return users;
    }

    /**
     * Return users list sorted by names and ages in ascending order.
     *
     * @param users unsorted list of users
     * @return users list sorted by name and age
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                String o1Name = o1.getName(), o2Name = o2.getName();
                int result = o1Name.compareTo(o2Name);
                return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return users;
    }
}
