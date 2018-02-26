package ru.job4j.user;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserLogTest {
    @Test
    public void whenAddUserWithNewIdThenTrue() {
        UserLog log = new UserLog();
        assertTrue(log.add(new User(1, "Name", "City")));
    }

    @Test
    public void whenAddUserWithSameIdThenFalse() {
        UserLog log = new UserLog();
        log.add(new User(1, "Name", "City"));
        assertFalse(log.add(new User(1, "", "")));
    }

    @Test
    public void whenAddUserThenCanGetUser() {
        UserLog log = new UserLog();
        User user = new User(1, "Name", "City");
        log.add(user);
        assertEquals(user, log.get(1));
    }

    @Test
    public void whenGetUserThatNotExistThenNull() {
        UserLog log = new UserLog();
        assertNull(log.get(1));
    }

    @Test
    public void whenDeleteUserThatNotExistThanFalse() {
        UserLog log = new UserLog();
        assertFalse(log.delete(1));
    }

    @Test
    public void whenDeleteUserThatAlreadyDeletedThanFalse() {
        UserLog log = new UserLog();
        log.add(new User(1, "Name", "City"));
        log.delete(1);
        assertFalse(log.delete(1));
    }

    @Test
    public void whenDeleteUserThatExistThanTrue() {
        UserLog log = new UserLog();
        log.add(new User(1, "Name", "City"));
        assertTrue(log.delete(1));
    }

    @Test
    public void whenUpdateUserThatExistThenTrue() {
        UserLog log = new UserLog();
        log.add(new User(1, "Name", "City"));
        assertTrue(log.update(new User(1, "newName", "newCity")));
    }

    @Test
    public void whenUpdateUserThatNotExistThenFalse() {
        UserLog log = new UserLog();
        assertFalse(log.update(new User(1, "newName", "newCity")));
    }

    @Test
    public void whenUpdateUserThenGetNewInfo() {
        UserLog log = new UserLog();
        User user = new User(1, "newName", "newCity");
        log.add(new User(1, "Name", "City"));
        log.update(user);
        assertEquals(user, log.get(1));
    }

    @Test
    public void whenGetHistoryByChangedUserThenGetStatesListInReverseOrder() {
        UserLog log = new UserLog();
        User user = new User(1, "Name", "City");
        User changes = new User(1, "newName", "newCity");
        List<User> users = new ArrayList<>();
        users.add(changes);
        users.add(user);
        log.add(user);
        log.update(changes);
        assertEquals(users, log.getHistory(1));
    }

    @Test
    public void whenGetHistoryByUserThatNotExistThenGetNull() {
        UserLog log = new UserLog();
        assertNull(log.getHistory(1));
    }
}