package ru.job4j.generic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class UserStore.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 13.01.2018
 */
public class UserStoreTest {
    /**
     * Test findById when element with the id doesn't add, have to return null.
     */
    @Test
    public void whenEmptyStoreThenFindSomeReturnNull() {
        Store<User> store = new UserStore(1);
        assertNull(store.findById("some"));
    }

    /**
     * When add User and try to find by it's identifier then found it.
     */
    @Test
    public void whenAddUserThenFindIt() {
        Store<User> store = new UserStore(1);
        User user = new User("first");
        store.add(user);
        assertEquals(user, store.findById(user.getId()));
    }

    /**
     * Test if not in store than replace return false.
     */
    @Test
    public void whenNotInStoreThenReplaceSomeFalse() {
        Store<User> store = new UserStore(1);
        assertFalse(store.replace("some", new User("some")));
    }

    /**
     * Test when some replace by other then you can find some and cant find other by identifier.
     */
    @Test
    public void whenSomeInStoreThenReplaceSomeTrueAndFindOther() {
        Store<User> store = new UserStore(1);
        User other = new User("other");
        store.add(new User("some"));
        assertTrue(store.replace("some", other));
        assertEquals(other, store.findById("other"));
        assertNull(store.findById("some"));
    }

    /**
     * Test if not in store than delete return false.
     */
    @Test
    public void whenNotInStoreThenDeleteSomeFalse() {
        Store<User> store = new UserStore(1);
        assertFalse(store.delete("some"));
    }

    /**
     * Test when some delete from store true then find return null.
     */
    @Test
    public void whenSomeInStoreThenDeleteSomeTrueAndFindNull() {
        Store<User> store = new UserStore(1);
        store.add(new User("some"));
        assertTrue(store.delete("some"));
        assertNull(store.findById("some"));
    }
}