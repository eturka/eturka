package ru.job4j.sort;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Test User.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 29.12.2017
 */
public class UserTest {
    /**
     * Test equals if user1 = user2 is true.
     */
    @Test
    public void equalsTrue() {
        User user1 = new User("Ivan", 1), user2 = new User("Ivan", 1);
        assertEquals(user1, user2);
    }

    /**
     * Test equals if user1 != user2 is false.
     */
    @Test
    public void equalsFalse() {
        User user1 = new User("Ivan", 1), user2 = new User("Petr", 2);
        assertNotEquals(user1, user2);
    }

    /**
     * Test hashCode. HashCodes on equals Users have to be equals.
     */
    @Test
    public void ifEqualsUsersThanHashCodeEquals() {
        User user1 = new User("Ivan", 1), user2 = new User("Ivan", 1);
        assertThat(user1.hashCode(), is(user2.hashCode()));
    }

    /**
     * If user2 older than user1 than compareTo return -1.
     */
    @Test
    public void compareToOlder() {
        User user1 = new User("Petr", 1), user2 = new User("Ivan", 2);
        assertThat(user1.compareTo(user2), is(-1));
    }

    /**
     * If user2 younger than user1 than compareTo return 1.
     */
    @Test
    public void compareToYounger() {
        User user1 = new User("Petr", 2), user2 = new User("Ivan", 1);
        assertThat(user1.compareTo(user2), is(1));
    }

    /**
     * If user1 is the same old as user2 than compareTo return 0.
     */
    @Test
    public void compareToCoeval() {
        User user1 = new User("Ivan", 1), user2 = new User("Ivan", 1);
        assertThat(user1.compareTo(user2), is(0));
    }
}