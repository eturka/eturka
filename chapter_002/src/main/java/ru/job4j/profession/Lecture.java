package ru.job4j.profession;

/**
 * Class Lecture.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 26.10.2017
 */
public class Lecture {
    /**
     * Lecture name.
     */
    private String name;
    /**
     * Duration of the lecture.
     */
    private int duration;

    /**
     * @param name     lecture name
     * @param duration duration of the lecture
     */
    public Lecture(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    /**
     * @return lecture name
     */
    public String getName() {
        return name;
    }


    /**
     * @return duration of the lecture
     */
    public int getDuration() {
        return duration;
    }
}
