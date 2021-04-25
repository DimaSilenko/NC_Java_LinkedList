package com.homework.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Проверим работоспособность методов моего списка:");
        tryMyList();

        System.out.println();
        Tests t = new Tests();

        int size = 50000;
        System.out.println("Сравним мой список и встроенный:");
        t.compareMyListAndJavaList(size);

        System.out.println();
        System.out.println("Сравним ArrayList и LinkedList:");
        t.compareLists(size);

        System.out.println();
        System.out.println("Сравним HashSet, LinkedHashSet, TreeSet:");
        t.compareSet(size);

        System.out.println();
        System.out.println("Сравним HashMap, LinkedHashMap, TreeMap:");
        t.compareMap(size);

    }

    public static void printList(MyLinkedList<Integer> l) {
        for (Integer e: l) {
            System.out.println(e);
        }
    }

    public static void tryMyList() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        System.out.println("Размер списка: " + list.size());
        System.out.println("Элемент 1 на позиции: " + list.indexOf(1));
        System.out.println();

        list.add(0, -4);
        //list.addLast(-4);
        list.add(0, 1);
        //list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(15);
        list.addLast(666);
        list.add(3, -777);
        list.add(5, 1999);
        list.add(1, -74);
        list.addLast(null);

        System.out.println("Размер списка: " + list.size());
        System.out.println(list.toString());

        System.out.println();
        System.out.println("Ищем по индексу 4: " + list.get(4));

        System.out.println();
        System.out.println("Элемент 1999 на позиции: " + list.indexOf(1999));
        System.out.println();
        System.out.println("Элемент 889 на позиции: " + list.indexOf(889));

        System.out.println();
        System.out.println("Извлекаем элемент по индексу 7: " + list.remove(7));
        System.out.println("После этого список из " + list.size() + " элесентов выглядит так: " + list.toString());

        list.set(2, 125);
        System.out.println("Изменим элемент с индексом 2 на 125 и получим: " + list.toString());

        System.out.println();
        System.out.println("Проверяем for each");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        printList(list);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println();
        System.out.println("Очистим список");
        list.clear();
        System.out.println(list.toString());
    }
}
