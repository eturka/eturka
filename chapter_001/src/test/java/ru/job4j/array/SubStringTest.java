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
public class SubStringTest {
    /**
     * Test substring.
     */
    @Test
    public void whenTexInSomeTextThanTrue() {
        SubString subString = new SubString();
        boolean result = subString.contains("SomeText", "Tex");
        assertThat(result, is(true));
    }
}
