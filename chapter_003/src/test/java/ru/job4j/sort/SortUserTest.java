package ru.job4j.sort;

import org.junit.Test;

import java.util.Arrays;
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
                new User("Petr", 25),
                new User("Ivan", 30)
        };
        Set<User> users = new SortUser().sort(Arrays.asList(expect[2], expect[0], expect[1]));
        assertArrayEquals(users.toArray(new User[2]), expect);
    }
}