package ru.job4j.generic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class RoleStore.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 13.01.2018
 */
public class RoleStoreTest {
    /**
     * Test findById when element with the id doesn't add, have to return null.
     */
    @Test
    public void whenEmptyStoreThenFindSomeReturnNull() {
        Store<Role> store = new RoleStore(1);
        assertNull(store.findById("some"));
    }

    /**
     * When add Role and try to find by it's identifier then found it.
     */
    @Test
    public void whenAddRoleThenFindIt() {
        Store<Role> store = new RoleStore(1);
        Role role = new Role("first");
        store.add(role);
        assertEquals(role, store.findById(role.getId()));
    }

    /**
     * Test if not in store than replace return false.
     */
    @Test
    public void whenNotInStoreThenReplaceSomeFalse() {
        Store<Role> store = new RoleStore(1);
        assertFalse(store.replace("some", new Role("some")));
    }

    /**
     * Test when some replace by other then you can find some and cant find other by identifier.
     */
    @Test
    public void whenSomeInStoreThenReplaceSomeTrueAndFindOther() {
        Store<Role> store = new RoleStore(1);
        Role other = new Role("other");
        store.add(new Role("some"));
        assertTrue(store.replace("some", other));
        assertEquals(other, store.findById("other"));
        assertNull(store.findById("some"));
    }

    /**
     * Test if not in store than delete return false.
     */
    @Test
    public void whenNotInStoreThenDeleteSomeFalse() {
        Store<Role> store = new RoleStore(1);
        assertFalse(store.delete("some"));
    }

    /**
     * Test when some delete from store true then find return null.
     */
    @Test
    public void whenSomeInStoreThenDeleteSomeTrueAndFindNull() {
        Store<Role> store = new RoleStore(1);
        store.add(new Role("some"));
        assertTrue(store.delete("some"));
        assertNull(store.findById("some"));
    }
}