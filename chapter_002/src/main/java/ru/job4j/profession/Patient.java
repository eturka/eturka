package ru.job4j.profession;

/**
 * Class Patient.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 26.10.2017
 */
public class Patient {
    /**
     * Result of the diagnostic.
     */
    private Diagnose diagnose = null;

    /**
     * @param diagnose result of the diagnostic
     */
    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }

    /**
     * Heal the patient.
     */
    public void recover() {
        if (this.diagnose != null) {
            this.diagnose = null;
            System.out.println("The patient was successfully recover!");
        } else {
            System.out.println("The patient is healthy, there is nothing to heal.");
        }
    }
}
