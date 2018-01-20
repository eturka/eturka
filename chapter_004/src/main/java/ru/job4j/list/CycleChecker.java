package ru.job4j.list;

/**
 * Class CycleChecker.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 21.01.2018
 */
public class CycleChecker {
    /**
     * Check if list have cycle licks.
     *
     * @param first link on first element of list
     * @return true | false if list have cycle link, if it hasn't
     */
    boolean hasCycle(Node first) {
        Node slow = first, fast = first.getNext();
        boolean has = false;
        while (fast != null && fast.getNext() != null) {
            if (fast.equals(slow)) {
                has = true;
                break;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return has;
    }
}

