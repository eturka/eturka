package ru.job4j.list;

/**
 * Class Node.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 18.01.2018
 */
public class Node<E> {
    /**
     * Value of element.
     */
    private E value;
    /**
     * Link to next element.
     */
    private Node<E> next;

    /**
     * Create new Node with empty next and value.
     *
     * @param value of the element
     */
    public Node(E value) {
        this.value = value;
        this.next = null;
    }

    /**
     * @return Node value
     */
    public E getValue() {
        return this.value;
    }

    /**
     * @return next Node
     */
    public Node<E> getNext() {
        return this.next;
    }

    /**
     * @param next link to next Node
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
}

