package ru.job4j.set;

/**
 * Class SetContainer can store elements with different hash codes (except null value).
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 27.01.2018
 */
public class SetContainer<E> {
    /**
     * Division number to calculate index by hash.
     */
    private int divisor = 1;
    /**
     * Count of elements in container.
     */
    private int count = 0;
    /**
     * Container.
     */
    private Object[] container = new Object[calculateSize()];

    /**
     * Add new element to container.
     *
     * @param element new element
     * @return true | false if can add, if element already added
     */
    public boolean add(E element) {
        boolean added = false;
        if (element != null) {
            int hash = element.hashCode(), index = calculateIndex(hash);
            if (this.container[index] == null || this.container[index].hashCode() != hash) {
                if (this.container[index] != null) {
                    expand(hash);
                    index = calculateIndex(hash);
                }
                this.container[index] = element;
                count++;
                added = true;
            }
        }
        return added;
    }

    /**
     * Check if container has element.
     *
     * @param element checked element
     * @return true | false if element is in the container, if it isn't
     */
    public boolean contains(E element) {
        return element != null && this.container[calculateIndex(element.hashCode())] != null;
    }

    /**
     * Remove element from the set if it is there.
     *
     * @param element deleted element
     * @return true | false if element was removed, if doesn't
     */
    public boolean remove(E element) {
        boolean removed = false;
        if (contains(element)) {
            this.container[calculateIndex(element.hashCode())] = null;
            this.count--;
            removed = true;
        }
        return removed;
    }

    /**
     * Expand array to size when it wouldn't have indexes collision with new hash.
     *
     * @param hash new hash code
     */
    private void expand(int hash) {
        int[] hashes = getAllHashes(hash);
        while (hasCollision(hashes)) {
            this.divisor++;
        }
        Object[] newContainer = new Object[calculateSize()];
        for (Object value : this.container) {
            if (value != null) {
                newContainer[calculateIndex(value.hashCode())] = value;
            }
        }
        this.container = newContainer;
    }

    /**
     * Return array with hashes of all elements of container contains new hash.
     *
     * @param hash new hash code
     * @return array of hashes
     */
    private int[] getAllHashes(int hash) {
        int[] hashes = new int[this.count + 1];
        hashes[0] = hash;
        int i = 1;
        for (Object element : this.container) {
            if (element != null) {
                hashes[i++] = element.hashCode();
            }
        }
        return hashes;
    }

    /**
     * Check if hashes by current indexation will have collisions.
     *
     * @param hashes array of hash codes
     * @return true | false if has collision, if doesn't
     */
    private boolean hasCollision(int[] hashes) {
        boolean[] occupied = new boolean[calculateSize()];
        boolean has = false;
        for (int hash : hashes) {
            int index = calculateIndex(hash);
            if (occupied[index]) {
                has = true;
                break;
            }
            occupied[index] = true;
        }
        return has;
    }

    /**
     * Calculate container's index by hash and divisor.
     *
     * @param hash element hash code
     * @return index in container
     */
    private int calculateIndex(int hash) {
        return hash % this.divisor + this.divisor - 1;
    }

    /**
     * Calculate necessary size of container for current divisor.
     *
     * @return container size
     */
    private int calculateSize() {
        return this.divisor * 2 - 1;
    }
}
