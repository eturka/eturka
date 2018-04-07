package ru.job4j.threads;

/**
 * Class Time works like a timer for thread counter.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 03.04.2018
 */
public class Time implements Runnable {
    /**
     * Time period for timer.
     */
    private final long period;
    /**
     * Counter.
     */
    private final Thread counter;

    /**
     * Create new period of for counter.
     *
     * @param period  while counter will work
     * @param counter some thread
     */
    public Time(long period, Thread counter) {
        this.period = period;
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(period);
        } catch (InterruptedException e) {
            System.out.println("Timer was interrupted!");
        }
        counter.interrupt();
    }

    public static void main(String[] args) {
        Thread counter = new Thread(new CountChar());
        new Thread(new Time(5, counter)).start();
        counter.start();
    }
}
