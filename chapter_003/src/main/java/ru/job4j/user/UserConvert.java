package ru.job4j.user;

import java.util.HashMap;
import java.util.List;

/**
 * Class UserConvert.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 29.12.2017
 */
public class UserConvert {
    /**
     * Create Map of pairs (user.id => user) from the List of Users.
     *
     * @param list Users List
     * @return Map of Users
     */
    HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> users = new HashMap<>();
        for (User user : list) {
            users.put(user.getId(), user);
        }
        return users;
    }
}
