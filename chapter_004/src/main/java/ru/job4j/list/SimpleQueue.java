package ru.job4j.list;

/**
 * Class SimpleQueue.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 20.01.2018
 */
public class SimpleQueue<T> {
    /**
     * Link on first element of the list.
     */
    private Node<T> first = null;
    /**
     * Link on last element of the list.
     */
    private Node<T> last = null;

    /**
     * Take element from the queue.
     *
     * @return element
     */
    public T poll() {
        T value = null;
        if (this.first != null) {
            value = this.first.getValue();
            this.first = this.first.getNext();
        }
        return value;
    }

    /**
     * Add new element to the queue.
     *
     * @param value element
     */
    public void push(T value) {
        if (this.first == null) {
            this.first = new Node<>(value);
            this.last = this.first;
        } else {
            this.last.setNext(new Node<>(value));
            this.last = this.last.getNext();
        }
    }
}