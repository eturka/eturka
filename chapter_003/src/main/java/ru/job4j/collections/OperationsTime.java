package ru.job4j.collections;

import java.util.*;

/**
 * Class OperationsTime gives opportunity to test how many time some {@link Collection} need to add or delete
 * random count of {@link String} elements.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 28.12.2017
 */
public class OperationsTime {

    /**
     * Count time to add random amount of strings to collection.
     *
     * @param collection some collection
     * @param amount     of string
     * @return time for operation
     */
    public static long add(Collection<String> collection, int amount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(String.valueOf(i));
        }
        return System.nanoTime() - startTime;
    }

    /**
     * Count time to delete random count of strings from the start of collection.
     *
     * @param collection some collection
     * @param amount     of string
     * @return time for operation
     */
    public static long delete(Collection<String> collection, int amount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.remove(String.valueOf(i));
        }
        return System.nanoTime() - startTime;
    }

    /**
     * Print results of add and delete operations for three types of Collections.
     *
     * @param add    count of elements to add
     * @param delete count of elements to delete
     * @see LinkedList
     * @see ArrayList
     * @see TreeSet
     */
    public static void printResults(int add, int delete) {
        Collection<String>[] collections = new Collection[]{
                new LinkedList<>(),
                new ArrayList<>(),
                new TreeSet<>()
        };
        System.out.println(String.format("%s %s %s",
                cutStr("Elements amount:"),
                cutStr("add = " + add),
                cutStr("del = " + delete)
        ));
        for (Collection<String> collection : collections) {
            System.out.println(String.format("%s %s %s",
                    cutStr(collection.getClass().getSimpleName()),
                    cutStr(add(collection, add)),
                    cutStr(delete(collection, delete))
            ));
        }
    }

    /**
     * Create string with constant length = 16.
     *
     * @param str some string
     * @return string with 16 char length
     */
    private static String cutStr(String str) {
        String newStr = "                " + str;
        return newStr.substring(newStr.length() - 16);
    }

    /**
     * Create string with constant length = 16.
     *
     * @param str some number
     * @return string with 16 char length
     */
    private static String cutStr(long str) {
        return cutStr(String.valueOf(str));
    }

    public static void main(String[] args) {
        int add = 10, delete = 1;
        for (int i = 0; i < 6; i++) {
            printResults(add, delete);
            System.out.println();
            add *= 10;
            delete *= 10;
        }
    }
}
