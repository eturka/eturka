package ru.job4j.threads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class SimpleBlockingQueue.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 10.04.2018
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    /**
     * Default size of queue.
     */
    private static final int DEFAULT_SIZE = 8;
    /**
     * Maximum size of queue.
     */
    private final int size;
    /**
     * Queue for values.
     */
    @GuardedBy("this.queue")
    private final Queue<T> queue = new LinkedList<>();

    /**
     * Create blocking queue with default maximum size.
     */
    public SimpleBlockingQueue() {
        this(DEFAULT_SIZE);
    }

    /**
     * Create blocking queue with specified maximum size.
     *
     * @param size maximum amount of elements in queue
     */
    public SimpleBlockingQueue(int size) {
        this.size = size;
    }

    /**
     * Offered new value to blocking queue.
     *
     * @param value new value
     * @throws InterruptedException because of wait method
     */
    public void offer(T value) throws InterruptedException {
        synchronized (this.queue) {
            while (this.queue.size() == size) {
                this.queue.wait();
            }
            if (this.queue.isEmpty()) {
                this.queue.notifyAll();
            }
            this.queue.add(value);
        }
    }

    /**
     * Get first value from blocking queue.
     *
     * @return value
     * @throws InterruptedException because of wait method
     */
    public T poll() throws InterruptedException {
        synchronized (this.queue) {
            while (this.queue.isEmpty()) {
                this.queue.wait();
            }
            if (this.queue.size() == size) {
                this.queue.notifyAll();
            }
            return this.queue.poll();
        }
    }
}
