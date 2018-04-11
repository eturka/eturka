package ru.job4j.threads;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class SimpleBlockingQueue.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 11.04.2018
 */
public class SimpleBlockingQueueTest {
    /**
     * Class Producer tested offer method.
     */
    private static class Producer implements Runnable {
        /**
         * Tested queue.
         */
        private final SimpleBlockingQueue<Integer> queue;
        /**
         * Initial array.
         */
        private final int[] array;

        /**
         * Create producer with initial array and queue for transfer.
         *
         * @param queue for transfer
         * @param array initial
         */
        private Producer(final SimpleBlockingQueue<Integer> queue, final int[] array) {
            this.queue = queue;
            this.array = array;
        }

        /**
         * Fill queue from initial array.
         */
        @Override
        public void run() {
            try {
                for (Integer value : this.array) {
                    this.queue.offer(value);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Class Consumer tested poll method.
     */
    private static class Consumer implements Runnable {
        /**
         * Tested queue.
         */
        private final SimpleBlockingQueue<Integer> queue;
        /**
         * Array for result.
         */
        private final int[] result;

        /**
         * Create consumer with empty array for result and queue for transfer.
         *
         * @param queue for transfer
         * @param count of elements for transfer
         */
        private Consumer(final SimpleBlockingQueue<Integer> queue, int count) {
            this.queue = queue;
            this.result = new int[count];
        }

        /**
         * @return result array
         */
        private int[] getResult() {
            return this.result;
        }

        /**
         * Fill array from queue.
         */
        @Override
        public void run() {
            try {
                for (int i = 0; i < this.result.length; i++) {
                    this.result[i] = this.queue.poll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void whenTransferArrayThenCanGetItInTheSameOrder() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Consumer result = new Consumer(queue, array.length);
        Thread producer = new Thread(new Producer(queue, array));
        Thread consumer = new Thread(result);
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        assertArrayEquals(array, result.getResult());
    }
}

