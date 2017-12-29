package ru.job4j.user;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test UserConvert.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 29.12.2017
 */
public class UserConvertTest {
    /**
     * From list contains two users create map which use id of the users as keys.
     */
    @Test
    public void process() {
        UserConvert userConvert = new UserConvert();
        User[] users = new User[]{
                new User(1, "user1", "city1"),
                new User(2, "user2", "city2")
        };
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, users[0]);
        expect.put(2, users[1]);
        assertEquals(userConvert.process(Arrays.asList(users)), expect);
    }

}