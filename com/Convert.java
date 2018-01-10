package com;

//Избыточное подключение
import java.util.*;
//Отсутствует javaDoc
public class Convert {

    //Конструктор по умолчнию не требуется указывать при отсутствии других
    public Convert(){

    }

    //Описание неполное, отсутствует модификатор доступа
    //Converts array to list
    List<Integer> makeList(int[][] array) {
        //Использован класс вместо интерфейса
        ArrayList<Integer> list = new ArrayList<>();
        //Можно заменить на комбинацию foreach + Arrays.asList(arrayLine);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                list.add(array[i][j]);
        }
        return list;
    }

    //Описание неполное
    //Converts list to array
    public int[][] makeArray(List<Integer> list, int rws) {
        Iterator<Integer> iterator = list.iterator();
        //Вычисление размера производится дважды
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);


        int[][] array = new int[rws][cls];
        for (int i = 0; i < rws; i++) {
            for (int j = 0; j < cls; j++) {
                if (iterator.hasNext())
                    array[i][j] = iterator.next();
                //Можно просто добавить break; т.к. массив int Изначально заполнен нулями
                else
                    array[i][j] = 0;
            }
        }
        return array;
    }
}