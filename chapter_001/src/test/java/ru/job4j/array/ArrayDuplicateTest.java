package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Ekaterina Turka (mailto:ekaterina2rka@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
    /**
     * Test duplicate.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] expected = new String[]{"Привет", "Мир", "Супер"};
        String[] result = array.remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"});
        assertThat(result, is(expected));
    }
}
