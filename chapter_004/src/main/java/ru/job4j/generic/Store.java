package ru.job4j.generic;

/**
 * Interface Store.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 13.01.2018
 */
public interface Store<T extends Base> {
    /**
     * Add new element.
     *
     * @param model element
     */
    void add(T model);

    /**
     * Replace element with index id by model.
     *
     * @param id    identifier of element
     * @param model new value
     * @return true | false if replaced, if cannot replace
     */
    boolean replace(String id, T model);

    /**
     * Delete element from Store by id.
     *
     * @param id identifier
     * @return true | false if deleted, if cannot delete
     */
    boolean delete(String id);

    /**
     * Search element by identifier.
     *
     * @param id identifier of element
     * @return element
     */
    T findById(String id);
}
