package ru.job4j.map;

import java.util.Arrays;
import java.util.Objects;

/**
 * Class HashExample.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 01.02.2018
 */
public class HashExample {
    /**
     * Multiplier for hashCode method.
     * You have to take simple odd number for better spreading, and because of par: 31 * i = (i << 5) - i computation
     * will be mor efficient.
     */
    private static final int MULTIPLIER = 31;
    /**
     * Base number for hashCode method (you may take random number).
     */
    private static final int BASE_HASH = 17;
    /**
     * Variable for storing hash code after first calculation.
     * Will be useful if you have to frequently count hashCode.
     */
    private int hashCode = 0;
    /**
     * Boolean value.
     */
    private final boolean b;
    /**
     * Char value.
     */
    private final char c;
    /**
     * Integer value.
     */
    private final int i;
    /**
     * Long integer value.
     */
    private final long l;
    /**
     * Double value.
     */
    private final double d;
    /**
     * Array of integers.
     */
    private final int[] a;
    /**
     * Link value.
     */
    private Object o;

    /**
     * Create example fill with different types of values.
     *
     * @param b boolean
     * @param c char
     * @param i integer
     * @param l long
     * @param d double
     * @param a array of integers
     * @param o link to HashExample
     */
    public HashExample(boolean b, char c, int i, long l, double d, int[] a, Object o) {
        this.b = b;
        this.c = c;
        this.i = i;
        this.l = l;
        this.d = d;
        this.a = a;
        this.o = o;
    }

    /**
     * Return hash for boolean value.
     *
     * @param value boolean
     * @return integer
     */
    private int hash(boolean value) {
        return value ? 1 : 0;
    }

    /**
     * Return hash for int (or smaller whole number type) value.
     *
     * @param value int | char | byte | short
     * @return integer
     */
    private int hash(int value) {
        return value;
    }

    /**
     * Return hash for long value.
     *
     * @param value long
     * @return integer
     */
    private int hash(long value) {
        return (int) (value ^ (value >>> 32));
    }

    /**
     * Return hash for double value.
     *
     * @param value double
     * @return integer
     */
    private int hash(double value) {
        return hash(Double.doubleToLongBits(value));
    }

    /**
     * Return hash for array of integers (will be same for any over types).
     *
     * @param value array of integers
     * @return integer
     */
    private int hash(int[] value) {
        int result = BASE_HASH;
        for (int element : value) {
            result = result * MULTIPLIER + hash(element);
        }
        return result;
    }

    /**
     * Return hash for any object.
     *
     * @param value object
     * @return integer
     */
    private int hash(Object value) {
        return value == null ? 0 : value.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HashExample that = (HashExample) o;
        return hashCode == that.hashCode
                && b == that.b
                && c == that.c
                && i == that.i
                && l == that.l
                && Double.compare(that.d, d) == 0
                && Arrays.equals(a, that.a)
                && Objects.equals(this.o, that.o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = BASE_HASH;
            this.hashCode = this.hashCode * MULTIPLIER + hash(this.b);
            this.hashCode = this.hashCode * MULTIPLIER + hash(this.c);
            this.hashCode = this.hashCode * MULTIPLIER + hash(this.i);
            this.hashCode = this.hashCode * MULTIPLIER + hash(this.l);
            this.hashCode = this.hashCode * MULTIPLIER + hash(this.d);
            this.hashCode = this.hashCode * MULTIPLIER + hash(this.a);
            this.hashCode = this.hashCode * MULTIPLIER + hash(this.o);
        }
        return this.hashCode;
    }
}
