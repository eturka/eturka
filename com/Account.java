package com;

//Отсутствует javaDoc
public class Account {

    double values; //Не указан модификатор доступа
    String reqs; //Не указан модификатор доступа, имя переменной не информативнное

    public Account(double values, String requisites) {
        this.values = values;
        this.reqs = requisites;
    }

    public double getValues() {
        return this.values;
    }


    public String getReqs () {
        return this.reqs;
    }

    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount; //Состояние объекта изменяется не через метод этого объекта
        }
        return success;
    }

    public String toString() {
        String otvet; //В проекте используются Английские наименования, это нарушает общую структуру
        //Нет this (хотя возможно в данном контексте его можно опустить, т.к. присуствуют только переменные объекта)
        otvet = "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
        return otvet; //Нет смысла в создании данной переменной, строку можно было сразу поместить в return
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.reqs.equals(account.reqs); //Получаение поля объекта не по геттеру
    }

    public int hashCode() {
        return this.reqs.hashCode();
    }
}