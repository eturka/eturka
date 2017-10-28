package ru.job4j.profession;

/**
 * Class Project.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 26.10.2017
 */
public class Project {
    /**
     * Project name.
     */
    private String name;

    /**
     * @param name project name
     */
    public Project(String name) {
        this.name = name;
    }

    /**
     * Build the project.
     */
    public void build() {
        System.out.println("Project " + this.name + " was build successfully.");
    }
}
