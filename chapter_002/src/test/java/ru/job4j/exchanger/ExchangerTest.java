package ru.job4j.exchanger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class Exchanger.
 *
 * @author Ekaterina Turka (mailto:ekaterina2rka@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ExchangerTest {

    /**
     * When the value is bigger than the price count change.
     *
     * @throws LackValueException when the price is bigger than insert value
     */
    @Test
    public void changes() throws LackValueException {
        Exchanger exchanger = new Exchanger();
        assertArrayEquals(exchanger.changes(63, 35), new int[]{1, 2, 5, 10, 10});
    }
}