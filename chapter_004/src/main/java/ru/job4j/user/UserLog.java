package ru.job4j.user;

import java.util.*;

/**
 * Class UserLog.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 25.02.2018
 */
public class UserLog {
    /**
     * Buckets contains users history with access by identifier.
     */
    private Map<Integer, LinkedList<User>> users = new HashMap<>();

    /**
     * Add new user if it have not exist.
     *
     * @param user new user
     * @return true | false, if was added, else
     */
    public boolean add(User user) {
        LinkedList<User> log = new LinkedList<>();
        return log.add(user) && (this.users.putIfAbsent(user.getId(), log) == null);
    }

    /**
     * Return user by it identifier.
     *
     * @param id identifier
     * @return user
     */
    public User get(int id) {
        LinkedList<User> log = this.users.get(id);
        return log != null ? log.getFirst() : null;
    }

    /**
     * Delete user from log by identifier if it exists.
     *
     * @param id identifier
     * @return true | false, if was deleted, else
     */
    public boolean delete(int id) {
        boolean deleted = false;
        LinkedList<User> log = this.users.get(id);
        if (log != null && log.getFirst() != null) {
            log.addFirst(null);
            deleted = true;
        }
        return deleted;
    }

    /**
     * Update user if it exists.
     *
     * @param user changed user
     * @return true | false if was updated, else
     */
    public boolean update(User user) {
        boolean updated = false;
        int id = user.getId();
        LinkedList<User> log = this.users.get(id);
        if (log != null) {
            log.addFirst(user);
            updated = true;
        }
        return updated;
    }

    /**
     * Return changes history by user id.
     *
     * @param id identifier
     * @return history log
     */
    public List<User> getHistory(int id) {
        return this.users.get(id);
    }
}
