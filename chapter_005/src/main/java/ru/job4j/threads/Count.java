package ru.job4j.threads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class Count.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 09.04.2018
 */
@ThreadSafe
public class Count {
    /**
     * Value of the counter.
     */
    @GuardedBy("this")
    private int value;

    /**
     * Increase value.
     */
    public synchronized void increment() {
        this.value++;
    }

    /**
     * Return counter value.
     *
     * @return value
     */
    public synchronized int get() {
        return this.value;
    }
}
