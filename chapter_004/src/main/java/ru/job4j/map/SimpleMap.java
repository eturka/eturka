package ru.job4j.map;

import java.util.HashSet;
import java.util.Set;

/**
 * Class SimpleMap.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 30.01.2018
 */
public class SimpleMap<K, V> {
    /**
     * Size of container.
     */
    private int size = 16;
    /**
     * Base container.
     */
    private Object[] container = new Object[size];
    /**
     * Keys hashes set.
     */
    private Set<Integer> hashes = new HashSet<>();

    /**
     * Add new entry to the map.
     *
     * @param key   identifier of the entry
     * @param value entries value
     * @return true | false if entry was inserted, if wasn't
     */
    public boolean insert(K key, V value) {
        boolean inserted = false;
        if (key != null) {
            int hash = key.hashCode();
            if (hashes.add(hash)) {
                int index = getIndex(hash);
                if (this.container[index] != null) {
                    resolveCollision(hash, this.container[index].hashCode());
                    index = getIndex(hash);
                }
                this.container[index] = new Entry(key, value);
                inserted = true;
            }
        }
        return inserted;
    }

    /**
     * Take entries from container by it's identifier.
     *
     * @param key identifier of the entry
     * @return entry value | null if wasn't found
     */
    public V get(K key) {
        Entry entry = null;
        if (key != null) {
            entry = (Entry) this.container[getIndex(key.hashCode())];
        }
        return entry != null ? entry.value : null;
    }

    /**
     * Delete entry from the container by it's identifier.
     *
     * @param key identifier of the entry
     * @return true | false if was deleted, if wasn't
     */
    public boolean delete(K key) {
        boolean deleted = false;
        if (key != null) {
            int index = getIndex(key.hashCode());
            if (this.container[index] != null) {
                this.container[index] = null;
                deleted = true;
            }
        }
        return deleted;
    }

    /**
     * Increase and reindex container to resolve collision.
     *
     * @param newHash hashCode of the new element
     * @param oldHash hashCode of element with same index
     */
    private void resolveCollision(int newHash, int oldHash) {
        do {
            this.size *= 2;
        } while (getIndex(newHash) == getIndex(oldHash));
        Object[] newContainer = new Object[this.size];
        for (Object element : this.container) {
            if (element != null) {
                Entry entry = (Entry) element;
                newContainer[getIndex(entry.key.hashCode())] = element;
            }
        }
        this.container = newContainer;
    }

    /**
     * Return index of the entry in container by the hash.
     *
     * @param hash entry key hash code
     * @return index
     */
    private int getIndex(int hash) {
        return hash & (this.size - 1);
    }

    /**
     * Inner class contains value and key of the entry.
     */
    private final class Entry {
        /**
         * Identifier of the entry.
         */
        private K key;
        /**
         * Value of the entry.
         */
        private V value;

        /**
         * Create new entry with key => value pair.
         *
         * @param key   identifier of the entry
         * @param value entries value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
