package ru.job4j.threads;

import net.jcip.annotations.GuardedBy;

/**
 * Class ThreadPool.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 11.04.2018
 */
public class ThreadPool {
    /**
     * Pool of threads.
     */
    private final Thread[] workers = new Worker[Runtime.getRuntime().availableProcessors()];
    /**
     * Queue of tasks.
     */
    private final SimpleBlockingQueue<Work> queue = new SimpleBlockingQueue<>();
    /**
     * Work indicator.
     */
    private volatile boolean active;
    /**
     * Work count.
     */
    @GuardedBy("this")
    private int counter = 0;

    /**
     * Class Work represents some task for the thread.
     */
    public static class Work implements Runnable {
        private final int number;

        public Work(int type) {
            this.number = type;
        }

        @Override
        public void run() {
            System.out.println(String.format("%s complete the task №%s", Thread.currentThread().getName(), this.number));
        }
    }

    /**
     * Class Worker represents a thread which run work from the queue.
     */
    private class Worker extends Thread {
        @Override
        public void run() {
            try {
                while (active) {
                    boolean execute = false;
                    synchronized (ThreadPool.this) {
                        if (counter > 0) {
                            execute = true;
                            counter--;
                        }
                    }
                    if (execute) {
                        queue.poll().run();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Create pool of working threads.
     */
    public ThreadPool() {
        for (int i = 0; i < this.workers.length; i++) {
            this.workers[i] = new Worker();
        }
    }

    /**
     * Command for workers to start working.
     */
    public void start() {
        synchronized (this) {
            this.active = true;
        }
        for (Thread worker : this.workers) {
            worker.start();
        }
    }

    /**
     * Command for workers to stop working.
     */
    public void stop() {
        synchronized (this) {
            this.active = false;
        }
    }

    /**
     * Add new work for workers.
     *
     * @param work new task
     */
    private void add(Work work) throws InterruptedException {
        this.queue.offer(work);
        synchronized (this) {
            this.counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool();
        pool.start();
        for (int i = 0; i < 30; i++) {
            pool.add(new Work(i));
        }
        Thread.sleep(500);
        pool.stop();
    }
}
