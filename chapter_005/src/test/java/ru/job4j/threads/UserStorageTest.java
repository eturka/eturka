package ru.job4j.threads;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Test class UserStorage.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 09.04.2018
 */
public class UserStorageTest {
    /**
     * Thread with storage.
     */
    private class ThreadStorage extends Thread {
        /**
         * Counter.
         */
        private final UserStorage storage;

        /**
         * Create new thread with storage.
         *
         * @param storage of users
         */
        private ThreadStorage(final UserStorage storage) {
            this.storage = storage;
        }

        /**
         * Execute transfer method of the storage.
         */
        @Override
        public void run() {
            this.storage.transfer(1, 2, 10);
        }
    }

    @Test
    public void whenExecute2ThreadsThenAmountChangedBy20() throws Exception {
        UserStorage storage = new UserStorage();
        UserStorage.User userFrom = new UserStorage.User(1, 30);
        UserStorage.User userTo = new UserStorage.User(2, 20);
        storage.add(userFrom);
        storage.add(userTo);
        Thread first = new ThreadStorage(storage);
        Thread second = new ThreadStorage(storage);
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(storage.get(1).getAmount(), is(10));
        assertThat(storage.get(2).getAmount(), is(40));
    }

    @Test
    public void whenAddNewThenTrue() {
        UserStorage storage = new UserStorage();
        assertTrue(storage.add(new UserStorage.User(1, 100)));
    }

    @Test
    public void whenAddSameUserThenFalse() {
        UserStorage storage = new UserStorage();
        storage.add(new UserStorage.User(1, 200));
        assertFalse(storage.add(new UserStorage.User(1, 100)));
    }

    @Test
    public void whenUpdateAddedUserThenTrue() {
        UserStorage storage = new UserStorage();
        storage.add(new UserStorage.User(1, 200));
        assertTrue(storage.update(new UserStorage.User(1, 100)));
    }

    @Test
    public void whenUpdateNewUserThenFalse() {
        UserStorage storage = new UserStorage();
        assertFalse(storage.update(new UserStorage.User(1, 100)));
    }

    @Test
    public void whenDeleteAddedUserThenTrue() {
        UserStorage storage = new UserStorage();
        storage.add(new UserStorage.User(1, 200));
        assertTrue(storage.delete(new UserStorage.User(1, 100)));
    }

    @Test
    public void whenDeleteNewUserThenFalse() {
        UserStorage storage = new UserStorage();
        assertFalse(storage.delete(new UserStorage.User(1, 100)));
    }

    @Test
    public void whenEnoughMoneyThenTransferTrue() {
        UserStorage storage = new UserStorage();
        storage.add(new UserStorage.User(1, 30));
        storage.add(new UserStorage.User(2, 20));
        assertTrue(storage.transfer(1, 2, 10));
    }

    @Test
    public void whenNotEnoughMoneyThenTransferFalse() {
        UserStorage storage = new UserStorage();
        storage.add(new UserStorage.User(1, 0));
        storage.add(new UserStorage.User(2, 20));
        assertFalse(storage.transfer(1, 2, 10));
    }

    @Test
    public void whenSameUserThenTransferFalse() {
        UserStorage storage = new UserStorage();
        storage.add(new UserStorage.User(1, 20));
        assertFalse(storage.transfer(1, 1, 10));
    }

    @Test
    public void whenUserNotExistThenTransferFalse() {
        UserStorage storage = new UserStorage();
        storage.add(new UserStorage.User(1, 20));
        assertFalse(storage.transfer(1, 2, 10));
    }
}