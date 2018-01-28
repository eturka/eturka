package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Test Map behaviour with keys types class User.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 28.01.2018
 */
public class UserMapTest {

    /**
     * Test for visual assert, in frame of task.
     */
    @Test
    public void whenAddTwoSameElementsWithoutOverridingEqualsThenPrintTwo() {
        Map<User, Object> map = new HashMap<>();
        Calendar birthday = new GregorianCalendar(1970, Calendar.JANUARY, 1);
        String name = "Ivan";
        int children = 0;
        User first = new User(name, birthday, children), second = new User(name, birthday, children);

        map.put(first, null);
        map.put(second, null);

        System.out.println(map);
    }
}