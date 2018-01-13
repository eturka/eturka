package ru.job4j.generic;

/**
 * Class AbstractStore.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 13.01.2018
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> array;

    /**
     * Create store base on SimpleArray.
     *
     * @param size store size
     */
    public AbstractStore(int size) {
        this.array = new SimpleArray<>(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(T model) {
        this.array.add(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean replace(String id, T model) {
        return this.array.update(this.getIndex(id), model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean delete(String id) {
        return this.array.delete(this.getIndex(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T findById(String id) {
        int index = getIndex(id);
        return index < 0 ? null : this.array.get(index);
    }

    /**
     * Return index of element with the identifier.
     *
     * @param id identifier
     * @return index | -1 if founded, if not found
     */
    private int getIndex(String id) {
        int index = 0;
        boolean found = false;
        for (T value : this.array) {
            if (value.getId().equals(id)) {
                found = true;
                break;
            }
            index++;
        }
        return found ? index : -1;
    }
}