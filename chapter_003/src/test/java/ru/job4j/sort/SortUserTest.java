package ru.job4j.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Class SortUser.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 29.12.2017
 */
public class SortUserTest {
    /**
     * Assert that unsorted list of users with age order (30, 20, 25) by sort command turn to set of users sorted by age
     * in ascending order. Use arrays for comparison.
     */
    @Test
    public void sort() {
        User[] expect = new User[]{
                new User("Pavel", 20),
                new User("Andrey", 25),
                new User("Ivan", 30)
        };
        Set<User> users = new SortUser().sort(Arrays.asList(expect[2], expect[0], expect[1]));
        assertArrayEquals(users.toArray(new User[2]), expect);
    }

    /**
     * Assert that unsorted list of users with name order (Andrey, Ivan, Pavel) by sortNameLength command turn to list
     * of users sorted by name length in ascending order.
     */
    @Test
    public void sortNameLength() {
        User[] users = new User[]{
                new User("Ivan", 30),
                new User("Pavel", 20),
                new User("Andrey", 25)
        };
        List<User> result = new SortUser().sortNameLength(Arrays.asList(users[2], users[0], users[1]));
        List<User> except = Arrays.asList(users);
        assertEquals(result, except);
    }

    /**
     * Assert that unsorted list of users with order ([Ivan, 20], [Andrey, 25], [Ivan, 30]) by sortByAllFields command
     * turn to list of users sorted by name and age in ascending order.
     */
    @Test
    public void sortByAllFields() {
        User[] users = new User[]{
                new User("Andrey", 25),
                new User("Ivan", 20),
                new User("Ivan", 30)
        };
        List<User> result = new SortUser().sortByAllFields(Arrays.asList(users[1], users[0], users[2]));
        List<User> except = Arrays.asList(users);
        assertEquals(result, except);
    }
}