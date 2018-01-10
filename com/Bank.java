package com;



//Класс User не подключен, возможны проблемы при расположении в разных пакетах
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//Отсутствует javaDoc
public class Bank {
    //В названии переменной не используется camelCase
    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();

    public void addUser(User user) {
        this.treemap.put(user, new ArrayList<>());
    }

    //Не информативное название метода, должно быть deleteUSer
    public void delete(User user) {
        this.treemap.remove(user);
    }

    //Не информативное название метода, должно быть addAccount
    public void add(User user, Account account) {
        //TreeMap может вернуть null, пропщенная проверка может привести к NullPointerException
        this.treemap.get(user).add(account);
    }

    private Account getActualAccount(User user, Account account) {
        //Лучше использовать интерфейс List
        ArrayList<Account> list = this.treemap.get(user);
        //TreeMap может вернуть null, пропщенная проверка может привести к NullPointerException
        //Если такой аккаунт отсутствует юудет брошена IndexOutOfBoundsException
        return list.get(list.indexOf(account));
    }

    public void deleteAccount(User user, Account account) {
        //TreeMap может вернуть null, пропщенная проверка может привести к NullPointerException
        this.treemap.get(user).remove(account);
    }

    public List<Account> getAccounts(User user) {
        return this.treemap.get(user);
    }

    public boolean transfer(User user1, Account account1,
                                 User user2, Account account2, double amount) {
        return this.treemap.get(user1).contains(account1)
                && this.treemap.get(user2).contains(account2)
                && getActualAccount(user1, account1).transfer(
                getActualAccount(user2, account2), amount);
    }

    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}