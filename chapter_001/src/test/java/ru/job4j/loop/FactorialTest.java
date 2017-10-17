package ru.job4j.loop;

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
public class FactorialTest {
    /**
     * Test factorial.
     */
    @Test
    public void whenFiveThenOneHundredTwenty() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Test factorial.
     */
    @Test
    public void whenZeroThenOne() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(1));
    }

}
