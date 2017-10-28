package ru.job4j.profession;

/**
 * Class Qualification contain information about employee qualification.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 26.10.2017
 */
public class Qualification {
    /**
     * Qualification degree.
     */
    private String degree;
    /**
     * Premium percent.
     */
    private int premium;

    /**
     * Initialize qualification.
     *
     * @param degree  qualification degree
     * @param premium premium percent
     */
    public Qualification(String degree, int premium) {
        this.degree = degree;
        this.premium = premium;
    }

    /**
     * @return premium percent
     */
    int getPremium() {
        return this.premium;
    }
}
