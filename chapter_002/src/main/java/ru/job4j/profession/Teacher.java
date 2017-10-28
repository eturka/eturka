package ru.job4j.profession;

/**
 * Class Teacher.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 26.10.2017
 */
public class Teacher extends Profession {
    /**
     * @param qualification qualification of employee
     * @param direction     professional direction
     */
    public Teacher(Qualification qualification, AcademicDirection direction) {
        super(qualification, direction);
    }

    /**
     * @param direction new professional direction
     */
    public void changeDirection(AcademicDirection direction) {
        super.changeDirection(direction);
    }

    /**
     * @param lecture some lecture
     */
    public void read(Lecture lecture) {
        System.out.println("Lecture " + lecture.getName() + " was reading for " + lecture.getDuration() + " minutes.");
    }

    /**
     * @param homework some homework
     */
    public void checkHomework(Homework homework) {
        homework.setGrade(5);
    }
}
