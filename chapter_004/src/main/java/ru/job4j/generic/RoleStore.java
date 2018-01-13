package ru.job4j.generic;

/**
 * Class RoleStore.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 13.01.2018
 */
public class RoleStore extends AbstractStore<Role> {
    /**
     * Create store of {@link Role} with the size.
     *
     * @param size store size
     */
    public RoleStore(int size) {
        super(size);
    }
}
