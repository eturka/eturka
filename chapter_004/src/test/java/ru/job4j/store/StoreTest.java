package ru.job4j.store;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test class Store.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 30.03.2018
 */
public class StoreTest {
    @Test
    public void whenEqualsUsersListsThenZeroChanges() {
        Store users = new Store();
        Store.User user1 = new Store.User(1, "first"), user2 = new Store.User(2, "second");
        List<Store.User> previous = new ArrayList<>(), current = new ArrayList<>();
        previous.add(user1);
        previous.add(user2);
        current.add(user1);
        current.add(user2);
        assertEquals(new Store.Info(0, 0, 0), users.diff(previous, current));
    }

    @Test
    public void whenAddNewUserThenInfoAddOne() {
        Store users = new Store();
        Store.User user1 = new Store.User(1, "first"), user2 = new Store.User(2, "second");
        List<Store.User> previous = new ArrayList<>(), current = new ArrayList<>();
        previous.add(user1);
        current.add(user1);
        current.add(user2);
        assertEquals(new Store.Info(1, 0, 0), users.diff(previous, current));
    }

    @Test
    public void whenDeleteUserThenInfoDeleteOne() {
        Store users = new Store();
        Store.User user1 = new Store.User(1, "first"), user2 = new Store.User(2, "second");
        List<Store.User> previous = new ArrayList<>(), current = new ArrayList<>();
        previous.add(user1);
        previous.add(user2);
        current.add(user1);
        assertEquals(new Store.Info(0, 0, 1), users.diff(previous, current));
    }

    @Test
    public void whenUpdateUserThenInfoUpdateOne() {
        Store users = new Store();
        Store.User user1 = new Store.User(1, "first"), user2 = new Store.User(2, "second"),
        changed = new Store.User(2, "changed");
        List<Store.User> previous = new ArrayList<>(), current = new ArrayList<>();
        previous.add(user1);
        previous.add(user2);
        current.add(user1);
        current.add(changed);
        assertEquals(new Store.Info(0, 1, 0), users.diff(previous, current));
    }

    @Test
    public void whenSameUsersThenEquals() {
        Store.User user1 = new Store.User(1, "first"), user2 = new Store.User(1, "first");
        assertEquals(user1, user2);
    }

    @Test
    public void whenDifferentNamesThenNotEquals() {
        Store.User user1 = new Store.User(1, "first"), user2 = new Store.User(1, "second");
        assertNotEquals(user1, user2);
    }

    @Test
    public void whenDifferentIdsThenNotEquals() {
        Store.User user1 = new Store.User(1, "first"), user2 = new Store.User(2, "first");
        assertNotEquals(user1, user2);
    }

    @Test
    public void whenSameInfoThenEquals() {
        Store.Info info1 = new Store.Info(1, 2, 3), info2 = new Store.Info(1, 2, 3);
        assertEquals(info1, info2);
    }

    @Test
    public void whenDifferentInfoThenNotEquals() {
        Store.Info info1 = new Store.Info(1, 2, 3), info2 = new Store.Info(3, 2, 1);
        assertNotEquals(info1, info2);
    }
}