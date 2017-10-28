package ru.job4j.profession;

/**
 * Class Doctor.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 26.10.2017
 */
public class Doctor extends Profession {
    /**
     * @param qualification qualification of employee
     * @param direction     professional direction
     */
    public Doctor(Qualification qualification, MedicineDirection direction) {
        super(qualification, direction);
    }

    /**
     * @param direction new professional direction
     */
    public void changeDirection(MedicineDirection direction) {
        super.changeDirection(direction);
    }

    /**
     * @param patient some patient
     */
    public void heal(Patient patient) {
        patient.recover();
    }

    /**
     * @param patient some patient
     */
    public void diagnose(Patient patient) {
        patient.setDiagnose(new Diagnose("disease"));
    }
}
