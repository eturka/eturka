package ru.job4j.map;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class SimpleMap.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 30.01.2018
 */
public class SimpleMapTest {
    @Test
    public void whenInsertNewKeyThenTrue() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        String key = "key", newKey = "newKey";
        Integer value = 123;

        assertTrue(map.insert(key, value));
        assertTrue(map.insert(newKey, value));
    }

    @Test
    public void whenInsertSameKeyThenFalse() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        String key = "key", sameKey = "key";
        Integer value1 = 123, value2 = 321;

        map.insert(key, value1);
        assertFalse(map.insert(sameKey, value2));
    }

    @Test
    public void whenInsertNullKeyThenFalse() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        String key = null;
        Integer value = 123;

        assertFalse(map.insert(key, value));
    }

    @Test
    public void whenDeleteNotExistKeyThenFalse() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        String key = "notExist";

        assertFalse(map.delete(key));
    }

    @Test
    public void whenDeleteNullKeyThenFalse() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        String key = null;

        assertFalse(map.delete(key));
    }

    @Test
    public void whenDeleteInsertedKeyThenTrue() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        String key = "key";
        Integer value = 1;

        map.insert(key, value);
        assertTrue(map.delete(key));
    }

    @Test
    public void whenDoubleDeleteKeyThenSecondFalse() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        String key = "key";
        Integer value = 1;

        map.insert(key, value);
        map.delete(key);
        assertFalse(map.delete(key));
    }

    @Test
    public void whenGetKeyInsertedKeyValueThenValue() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        String key = "key";
        Integer value = 1;

        map.insert(key, value);
        assertEquals(map.get(key), value);
    }

    @Test
    public void whenGetNotExistKeyThenNull() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        String key = "notExist";

        assertNull(map.get(key));
    }

    @Test
    public void whenGetNullKeyThenNull() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        String key = null;

        assertNull(map.get(key));
    }
}