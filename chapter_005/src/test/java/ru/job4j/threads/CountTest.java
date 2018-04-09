package ru.job4j.threads;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class CountTest show how class Count can work with concurrency.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 09.04.2018
 */
public class CountTest {
    /**
     * Thread with counter.
     */
    private class ThreadCount extends Thread {
        /**
         * Counter.
         */
        private final Count count;

        /**
         * Create new thread with counter.
         *
         * @param count counter
         */
        private ThreadCount(final Count count) {
            this.count = count;
        }

        /**
         * Execute increment method of the counter.
         */
        @Override
        public void run() {
            this.count.increment();
        }
    }

    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        final Count count = new Count();
        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(count.get(), is(2));
    }
}
