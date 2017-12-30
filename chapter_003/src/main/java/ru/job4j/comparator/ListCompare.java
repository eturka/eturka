package ru.job4j.comparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Class ListCompare.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 30.12.2017
 */
public class ListCompare implements Comparator<List<Integer>> {
    /**
     * Compare elements of lists by using compareTo for Integers. But if all elements are equals but one list is longer
     * than another, than list which is longer will be count as larger.
     * {@inheritDoc}
     */
    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        int result = 0;
        Iterator<Integer> iteratorLeft = left.iterator(), iteratorRight = right.iterator();
        while (result == 0) {
            boolean emptyLeft = !iteratorLeft.hasNext(), emptyRight = !iteratorRight.hasNext();
            if (emptyRight || emptyLeft) {
                result = emptyLeft ? (emptyRight ? 0 : -1) : 1;
                break;
            }
            result = iteratorLeft.next().compareTo(iteratorRight.next());
        }
        return result;
    }
}