package ru.job4j.profession;

/**
 * Class Profession.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 26.10.2017
 */
public abstract class Profession {
    /**
     * Qualification of employee.
     */
    private Qualification qualification;
    /**
     * Professional direction.
     */
    protected Direction direction;

    /**
     * @param qualification qualification of employee
     * @param direction     professional direction
     */
    public Profession(Qualification qualification, Direction direction) {
        this.qualification = qualification;
        this.direction = direction;
    }

    /**
     * @param rate base rate of employee
     * @return total salary with bonus for qualification
     */
    public double countSalary(double rate) {
        return this.qualification.getPremium() * rate;
    }

    /**
     * @param direction new professional direction
     */
    protected void changeDirection(Direction direction) {
        System.out.println("The direction " + this.direction.getName() + " was successfully changed to " + direction.getName());
        this.direction = direction;
    }
}
