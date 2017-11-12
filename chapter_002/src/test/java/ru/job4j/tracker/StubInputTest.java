package ru.job4j.tracker;

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
public class StubInputTest {
    /**
     * Test ask.
     */
    @Test
    public void whenAddTestThanAskReturnTest() {
        Input input = new StubInput(new String[]{"test"});
        assertThat(input.ask(""), is("test"));
    }
}
