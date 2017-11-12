package ru.job4j.paint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Ekaterina Turka (mailto:ekaterina2rka@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStream() {
        System.setOut(null);
    }

    /**
     * Test square pic.
     */
    @Test
    public void whenPicSquareThanStringSquare() {
        String square = "++" + System.lineSeparator() + "++" + System.lineSeparator();
        new Paint().draw(new Square());
        assertThat(outContent.toString(), is(square));
    }

    /**
     * Test triangle pic.
     */
    @Test
    public void whenPicTriangleThanStringTriangle() {
        String square = " ^ " + System.lineSeparator() + "^^^" + System.lineSeparator();
        new Paint().draw(new Triangle());
        assertThat(outContent.toString(), is(square));
    }
}
