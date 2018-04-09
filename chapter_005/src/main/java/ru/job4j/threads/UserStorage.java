package ru.job4j.threads;

import net.jcip.annotations.ThreadSafe;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Class UserStorage.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 09.04.2018
 */
@ThreadSafe
public class UserStorage {
    /**
     * User storage.
     */
    private final ConcurrentMap<Integer, User> users = new ConcurrentHashMap<>();

    /**
     * Class User.
     */
    public static class User {
        /**
         * User's identifier.
         */
        private int id;
        /**
         * User's money amount.
         */
        private int amount;

        /**
         * Create new User with identifier and balance.
         *
         * @param id     identifier
         * @param amount balance
         */
        public User(int id, int amount) {
            this.id = id;
            this.amount = amount;
        }

        /**
         * @return user's identifier
         */
        public int getId() {
            return id;
        }

        /**
         * @return user's balance
         */
        public int getAmount() {
            return amount;
        }

        /**
         * Change money amount on user's balance.
         *
         * @param amount new balance
         */
        public void setAmount(int amount) {
            this.amount = amount;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id && amount == user.amount;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    /**
     * Add new user to the storage.
     *
     * @param user new user
     * @return true | false, if user was added, otherwise
     */
    public boolean add(User user) {
        synchronized (this.users) {
            return this.users.putIfAbsent(user.getId(), user) == null;
        }
    }

    /**
     * Update user info in the storage.
     *
     * @param user new information about user
     * @return true | false, if was updated, otherwise
     */
    public boolean update(User user) {
        boolean updated = false;
        synchronized (this.users) {
            if (this.users.containsKey(user.getId())) {
                this.users.put(user.getId(), user);
                updated = true;
            }
        }
        return updated;
    }

    /**
     * Remove user from the storage.
     *
     * @param user removed user
     * @return true | false, if was removed, otherwise
     */
    public boolean delete(User user) {
        synchronized (this.users) {
            return this.users.remove(user.getId()) != null;
        }
    }

    /**
     * Return user by identifier.
     *
     * @param id identifier
     * @return user
     */
    public User get(int id) {
        synchronized (this.users) {
            return this.users.get(id);
        }
    }

    /**
     * Send money from one user to another.
     *
     * @param fromId sender id
     * @param toId   receiver id
     * @param amount of money
     * @return true | false, if money was sanded, otherwise
     */
    public boolean transfer(int fromId, int toId, int amount) {
        boolean transferred = false;
        synchronized (this.users) {
            User fromUser = this.users.get(fromId), toUser = this.users.get(toId);
            if (fromUser != null && toUser != null && fromUser != toUser) {
                int currentAmount = fromUser.getAmount();
                if (currentAmount >= amount) {
                    fromUser.setAmount(currentAmount - amount);
                    toUser.setAmount(toUser.getAmount() + amount);
                    transferred = true;
                }
            }
        }
        return transferred;
    }
}
