package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class Account.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 03.01.2018
 */
public class AccountTest {
    /**
     * Get value have to return value of account.
     */
    @Test
    public void getValue() {
        Account account = new Account("№123", 100);
        assertThat(account.getValue(), is(100D));
    }

    /**
     * Set value have to change value of account with new value.
     */
    @Test
    public void setValue() {
        Account account = new Account("№123");
        account.setValue(200);
        assertThat(account.getValue(), is(200D));
    }

    /**
     * If have enough money then return true.
     */
    @Test
    public void whenEnoughMoneyThenTrueAndChangeValues() {
        Account source = new Account("№123", 100);
        Account dest = new Account("№321");
        assertTrue(source.transferMoney(dest, 40));
        assertThat(source.getValue(), is(60D));
        assertThat(dest.getValue(), is(40D));
    }

    /**
     * If have not enough money then return false.
     */
    @Test
    public void whenNotEnoughMoneyThenFalseAndNotChangeValues() {
        Account source = new Account("№123", 30);
        Account dest = new Account("№321");
        assertFalse(source.transferMoney(dest, 40));
        assertThat(source.getValue(), is(30D));
        assertThat(dest.getValue(), is(0D));
    }

    /**
     * If accounts have equals requisites then they are equals.
     */
    @Test
    public void whenRequisitesEqualsThenEquals() {
        assertEquals(new Account("№123", 100), new Account("№123"));
    }

    /**
     * If accounts have different requisites then they are not equals.
     */
    @Test
    public void whenPassportNotEqualsThenNotEquals() {
        assertNotEquals(new Account("№123", 100), new Account("№321", 100));
    }

    /**
     * If accounts are equals they have same hashCodes.
     */
    @Test
    public void whenEqualsThenHashCodeSame() {
        Account account1 = new Account("№123", 100), account2 = new Account("№123");
        assertThat(account1.hashCode(), is(account2.hashCode()));
    }
}