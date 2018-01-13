package ru.job4j.generic;

/**
 * Class UserStore.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 13.01.2018
 */
public class UserStore extends AbstractStore<User> {
    /**
     * Create store of {@link User} with the size.
     *
     * @param size store size
     */
    public UserStore(int size) {
        super(size);
    }
}
