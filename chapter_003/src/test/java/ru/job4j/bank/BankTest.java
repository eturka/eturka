package ru.job4j.bank;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Test class Bank.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 03.01.2018
 */
public class BankTest {
    /**
     * Check that when add the user then it's in the Map.
     */
    @Test
    public void whenAddUserAndGetAccountsThenEmptyArray() {
        Bank bank = new Bank();
        bank.addUser(new User("№123", "Bob"));
        assertArrayEquals(bank.getUserAccounts("№123").toArray(), new Account[]{});
    }

    /**
     * Check that when delete the user then it isn't in the Map.
     */
    @Test
    public void whenDeleteUserAndGetAccountsThenNull() {
        Bank bank = new Bank();
        User user = new User("№123", "Bob");
        bank.addUser(user);
        bank.deleteUser(user);
        assertNull(bank.getUserAccounts("№123"));
    }

    /**
     * Check that if we add account to the user, then it is on the user's accounts.
     */
    @Test
    public void whenUserExistAndAddAccountToUserThenUserHasAccount() {
        Bank bank = new Bank();
        bank.addUser(new User("№123", "Bob"));
        Account account = new Account("#123");
        bank.addAccountToUser("№123", account);
        assertTrue(bank.getUserAccounts("№123").contains(account));
    }

    /**
     * Check that if we try to add account to user which not exists then NullPointerException will thrown.
     */
    @Test(expected = NullPointerException.class)
    public void whenUserNotExistAndAddAccountToUserThenException() {
        Bank bank = new Bank();
        bank.addAccountToUser("№123", new Account("#123"));
    }

    /**
     * Check that if we delete account from the user, then it is not on the user's accounts.
     */
    @Test
    public void deleteAccountFromUser() {
        Bank bank = new Bank();
        bank.addUser(new User("№123", "Bob"));
        Account account = new Account("#123");
        bank.addAccountToUser("№123", account);
        bank.deleteAccountFromUser("№123", account);
        assertFalse(bank.getUserAccounts("№123").contains(account));
    }

    /**
     * Check that if we try to delete account to user which not exists then NullPointerException will thrown.
     */
    @Test(expected = NullPointerException.class)
    public void whenUserNotExistAndDeleteAccountFromUserThenException() {
        Bank bank = new Bank();
        bank.deleteAccountFromUser("№123", new Account("#123"));
    }

    /**
     * Check that if we transfer money from user's account which have enough money to account of some other user (or
     * different account of same user) then transferMoney return true and values of accounts will changed.
     */
    @Test
    public void whenAllEntitiesExistAndEnoughMoneyThenTransferTrue() {
        Bank bank = new Bank();
        User sender = new User("№123"), recipient = new User("№321");

        bank.addUser(sender);
        bank.addUser(recipient);
        bank.addAccountToUser("№123", new Account("#123", 100));
        bank.addAccountToUser("№321", new Account("#321"));

        //Between different users
        assertTrue(bank.transferMoney("№123", "#123",
                "№321", "#321", 60));
        assertThat(bank.getUserAccounts("№123").get(0).getValue(), is(40D));
        assertThat(bank.getUserAccounts("№321").get(0).getValue(), is(60D));

        //Between different accounts of one user
        bank.addAccountToUser("№123", new Account("#111"));
        assertTrue(bank.transferMoney("№123", "#123",
                "№123", "#111", 30));
        assertThat(bank.getUserAccounts("№123").get(0).getValue(), is(10D));
        assertThat(bank.getUserAccounts("№123").get(1).getValue(), is(30D));
    }

    /**
     * Check that if some of entities (user or account) does not exist or sender have not enough money then transfer
     * will return false and accounts balances was not changed.
     */
    @Test
    public void whenSomeOfEntityNotExistOrNotEnoughMoneyThenTransferFalse() {
        Bank bank = new Bank();
        User sender = new User("№123"), recipient = new User("№321");

        //Both users and accounts are not exist
        assertFalse(bank.transferMoney("№123", "#123",
                "№321", "#321", 60));

        bank.addUser(sender);
        //Recipient and accounts are not exist
        assertFalse(bank.transferMoney("№123", "#123",
                "№321", "#321", 60));

        bank.addUser(recipient);
        //Both accounts are not exist
        assertFalse(bank.transferMoney("№123", "#123",
                "№321", "#321", 60));

        bank.addAccountToUser("№123", new Account("#123", 50));
        //Recipient account is not exist
        assertFalse(bank.transferMoney("№123", "#123",
                "№321", "#321", 60));

        bank.addAccountToUser("№321", new Account("#321"));
        //Sender account have not enough money
        assertFalse(bank.transferMoney("№123", "#123",
                "№321", "#321", 60));

        //Balances of accounts was not changed
        assertThat(bank.getUserAccounts("№123").get(0).getValue(), is(50D));
        assertThat(bank.getUserAccounts("№321").get(0).getValue(), is(0D));
    }
}