package ru.job4j.bank;

import java.util.Objects;

/**
 * Class Account.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 03.01.2018
 */
public class Account {
    /**
     * Account requisites.
     */
    private final String requisites;
    /**
     * Account balance.
     */
    private double value;

    /**
     * Create account with start balance value.
     *
     * @param requisites account requisites
     * @param value      balance value
     */
    public Account(String requisites, double value) {
        this.requisites = requisites;
        this.value = value;
    }

    /**
     * Create account with zero balance.
     *
     * @param requisites account requisites
     */
    public Account(String requisites) {
        this(requisites, 0);
    }

    /**
     * Get information about account balance value.
     *
     * @return balance value
     */
    public double getValue() {
        return value;
    }

    /**
     * Change balance value.
     *
     * @param value new value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Transfer money from current to destination account.
     *
     * @param account destination
     * @param amount  transfer value
     * @return true | false if transaction was successful, if current account haven't enough money
     */
    public boolean transferMoney(Account account, double amount) {
        boolean result = false;
        if (this.value >= amount) {
            this.value -= amount;
            account.setValue(account.getValue() + amount);
            result = true;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisites, account.requisites);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
}
