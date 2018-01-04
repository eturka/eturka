package ru.job4j.collections;

import java.util.*;

/**
 * Class DepartmentsSorter.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 04.01.2018
 */
public class DepartmentsSorter {
    /**
     * Ascend sort order.
     */
    private static final int ASC = 1;
    /**
     * Descend sort order.
     */
    private static final int DESC = -1;

    /**
     * Create sorted catalog of departments in ascending order.
     *
     * @param departments array of departments
     * @return array with hierarchy of departments sorted in ascending order
     */
    public String[] sortAscending(String[] departments) {
        return buildHierarchy(departments, ASC);
    }

    /**
     * Create sorted catalog of departments in descending order.
     *
     * @param departments array of departments
     * @return array with hierarchy of departments sorted in descending order
     */
    public String[] sortDescending(String[] departments) {
        return buildHierarchy(departments, DESC);
    }

    /**
     * Create set from departments array with hierarchy.
     *
     * @param departments array of departments
     * @param order       type of sort
     * @return array with hierarchy of departments
     */
    private String[] buildHierarchy(String[] departments, int order) {
        Set<List<String>> hierarchy = new TreeSet<>(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> left, List<String> right) {
                int result = 0;
                Iterator<String> iteratorLeft = left.iterator(), iteratorRight = right.iterator();
                while (result == 0) {
                    boolean emptyLeft = !iteratorLeft.hasNext(), emptyRight = !iteratorRight.hasNext();
                    if (emptyRight || emptyLeft) {
                        result = emptyLeft ? (emptyRight ? 0 : -1) : 1;
                        break;
                    }
                    result = iteratorLeft.next().compareTo(iteratorRight.next()) * order;
                }
                return result;
            }
        });
        for (String department : departments) {
            List<String> list = new ArrayList<>();
            for (String item : department.split("\\\\")) {
                list.add(item);
                hierarchy.add(new ArrayList<>(list));
            }
        }
        return catalogueToDepartments(hierarchy);
    }

    /**
     * Create departments array from catalogue of departments with hierarchy.
     *
     * @param catalogue set of lists contains department with hierarchy
     * @return array of departments
     */
    private String[] catalogueToDepartments(Set<List<String>> catalogue) {
        String[] departments = new String[catalogue.size()];
        int index = 0;
        for (List<String> department : catalogue) {
            departments[index++] = join(department);
        }
        return departments;
    }

    /**
     * Create string from list by using delimiter.
     * Custom interpretation of StringUtils method.
     *
     * @param list contain strings
     * @return string contains all string from list separated by delimiter
     */
    private String join(List<String> list) {
        StringBuilder buffer = new StringBuilder();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); buffer.append(iterator.next())) {
            if (buffer.length() != 0) {
                buffer.append("\\");
            }
        }
        return buffer.toString();
    }
}
