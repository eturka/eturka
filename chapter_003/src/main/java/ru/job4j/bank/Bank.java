package ru.job4j.bank;

import java.util.*;

/**
 * Class Bank.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @since 03.01.2018
 */
public class Bank {
    /**
     * Contain information about users and theirs accounts.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Add new user of bank if not already added.
     *
     * @param user new user
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Delete user from the bank users if it exists.
     *
     * @param user removable bank user
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * Add account to banks user by passport number if not already added.
     *
     * @param passport number
     * @param account  new user account
     */
    public void addAccountToUser(String passport, Account account) {
        List<Account> accounts = getUserAccounts(passport);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    /**
     * Add account to banks user by passport number if not already added.
     *
     * @param passport number
     * @param account  new user account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        getUserAccounts(passport).remove(account);
    }

    /**
     * Return list of accounts of the user by passport number.
     *
     * @param passport number
     * @return list
     */
    public List<Account> getUserAccounts(String passport) {
        return this.users.get(new User(passport));
    }

    /**
     * Make transfer between users accounts.
     *
     * @param srcPassport  passport number of sender
     * @param srcRequisite account requisite of sender
     * @param dstPassport  passport number of recipient
     * @param dstRequisite account requisite of recipient
     * @param amount       transfer sum
     * @return true | false if transaction was successful, if current account haven't enough money or some of accounts
     * or users wasn't found
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String dstPassport, String dstRequisite, double amount) {
        Account srcAccount = getAccount(getUserAccounts(srcPassport), srcRequisite);
        Account dstAccount = getAccount(getUserAccounts(dstPassport), dstRequisite);
        return srcAccount != null && dstAccount != null && srcAccount.transferMoney(dstAccount, amount);
    }

    /**
     * Searching account by requisite in the list.
     *
     * @param accounts  list of accounts
     * @param requisite wanted account requisite
     * @return wanted account
     */
    private Account getAccount(List<Account> accounts, String requisite) {
        Account account;
        if (accounts == null) {
            account = null;
        } else {
            int index = accounts.indexOf(new Account(requisite));
            account = index < 0 ? null : accounts.get(index);
        }
        return account;
    }
}
