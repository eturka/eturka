package ru.job4j.profession;

/**
 * Class Engineer.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 26.10.2017
 */
public class Engineer extends Profession {
    /**
     * @param qualification qualification of employee
     * @param direction     professional direction
     */
    public Engineer(Qualification qualification, EngineeringDirection direction) {
        super(qualification, direction);
    }

    /**
     * @param direction new professional direction
     */
    public void changeDirection(EngineeringDirection direction) {
        super.changeDirection(direction);
    }

    /**
     * @return project
     */
    public Project design() {
        return new Project("MyProject");
    }
}
