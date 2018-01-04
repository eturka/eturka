package ru.job4j.collections;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class DepartmentsSorter.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 04.01.2018
 */
public class DepartmentsSorterTest {
    /**
     * Test that if we add unsorted array of departments, sortAscending will return sorted catalog of departments in
     * ascending order.
     */
    @Test
    public void sortAscending() {
        DepartmentsSorter departmentsSorter = new DepartmentsSorter();
        String[] departments = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        String[] expect = {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        assertArrayEquals(departmentsSorter.sortAscending(departments), expect);
    }

    /**
     * Test that if we add unsorted array of departments, sortDescending will return sorted catalog of departments in
     * descending  order.
     */
    @Test
    public void sortDescending() {
        DepartmentsSorter departmentsSorter = new DepartmentsSorter();
        String[] departments = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        String[] expect = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        assertArrayEquals(departmentsSorter.sortDescending(departments), expect);
    }
}