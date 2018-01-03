package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class User.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 03.01.2018
 */
public class UserTest {
    /**
     * If users have equals passport numbers then they are equals.
     */
    @Test
    public void whenPassportEqualsThenEquals() {
        assertEquals(new User("123", "Bob"), new User("123"));
    }

    /**
     * If users have different passport numbers then they are not equals.
     */
    @Test
    public void whenPassportNotEqualsThenNotEquals() {
        assertNotEquals(new User("123", "Bob"), new User("321", "Bob"));
    }

    /**
     * If users are equals they have same hashCodes.
     */
    @Test
    public void whenEqualsThenHashCodeSame() {
        User user1 = new User("123", "Bob"), user2 = new User("123");
        assertThat(user1.hashCode(), is(user2.hashCode()));
    }
}