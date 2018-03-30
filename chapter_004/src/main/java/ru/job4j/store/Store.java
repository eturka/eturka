package ru.job4j.store;

import java.util.*;

/**
 * Class Store.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 20.03.2018
 */
public class Store {
    /**
     * Return information about changed in users store.
     *
     * @param previous store information
     * @param current store information
     * @return information about
     */
    public Info diff(List<User> previous, List<User> current) {
        int delete, add = 0, update = 0;
        Map<Integer, User> users = new HashMap<>();
        for (User user : previous) {
            users.put(user.id, user);
        }
        for (User user : current) {
            User old = users.get(user.id);
            if (old != null) {
                if (!old.equals(user)) {
                    update++;
                }
                users.remove(user.id);
            } else {
                add++;
            }
        }
        delete = users.size();
        return new Info(add, update, delete);
    }

    /**
     * Class User contains information about user.
     */
    public static class User {
        /**
         * User identifier.
         */
        private final int id;
        /**
         * User name.
         */
        private final String name;

        /**
         * Create new user with name and identifier.
         *
         * @param id user identifier
         * @param name user name
         */
        public User(int id, String name) {
            this.id = id;
            this.name = name;
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
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return id;
        }
    }

    /**
     * Statistic about changes in user store.
     */
    public static class Info {
        /**
         * Added users count.
         */
        private final int add;
        /**
         * Updated users count.
         */
        private final int update;
        /**
         * Deleted users count.
         */
        private final int delete;

        /**
         * Information about actions with users.
         *
         * @param add added users count
         * @param update updated users count
         * @param delete deleted users count
         */
        public Info(int add, int update, int delete) {
            this.add = add;
            this.update = update;
            this.delete = delete;
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
            Info info = (Info) o;
            return add == info.add
                    && update == info.update
                    && delete == info.delete;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return Objects.hash(add, update, delete);
        }
    }
}
