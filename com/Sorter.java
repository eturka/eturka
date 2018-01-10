package com;

//Избыточное подключение, класс User не подключен
import java.util.*;

//Отсутствует javaDoc
public class Sorter {

    //Конструктор по умолчнию не требуется указывать при отсутствии других
    public Sorter(){

    }

    //Отсутствует модификатор доступа
    Set<User> sort (List<User> list) {
        //Используется класс вместо интерфейса Set
        TreeSet<User> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        //Производятся лишние действия достаточно return new TreeSet<>(users);
        return sortedList;
    }

    //Отсутствует модификатор доступа, имя метода написано не по стандарту (camelCase), пробел между именем метода
    // и списком аргументов
    List<User> sortnamelength (List<User> list) {
        //Создана лишняя переменная, название использовано с нарушением грамматики, могут возникнуть проблемы при поиске
        Comparator<User> compar = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        list.sort(compar);
        return list;
    }

    //Отсутствует модификатор доступа, имя метода написано не по стандарту (camelCase) и не является информативным,
    // пробел между именем метода и списком аргументов
    List<User> sortboth (List<User> list) {
        //Созданы лишние переменные, название использовано с нарушением грамматики, могут возникнуть проблемы при поиске
        Comparator<User> compar1 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<User> compar2 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}