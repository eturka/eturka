package ru.job4j.list;

/**
 * Class SimpleStack.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 20.01.2018
 */
public class SimpleStack<T> {
    /**
     * Link on first element of the list.
     */
    private Node<T> top = null;

    /**
     * Take element from the stack.
     *
     * @return element
     */
    public T poll() {
        T value = null;
        if (this.top != null) {
            value = this.top.getValue();
            this.top = this.top.getNext();
        }
        return value;
    }

    /**
     * Add new element to the stack.
     *
     * @param value element
     */
    public void push(T value) {
        if (this.top == null) {
            this.top = new Node<>(value);
        } else {
            Node<T> element = new Node<>(value);
            element.setNext(this.top);
            this.top = element;
        }
    }
}