package com.homework.list;

import sun.awt.image.ImageWatched;

import java.util.*;

public class Tests {

    public Tests() {
    }

    private int[] genMas(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size);
        }
        return array;
    }

    public void compareMyListAndJavaList(int size) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        LinkedList<Integer> javaList = new LinkedList<>();

        int[] array = genMas(size);

        //------------------------------Добавление в начало---------------------------------------
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            myList.addFirst(array[i]);
        }
        long end = System.nanoTime();
        System.out.println("MyLinkedList! Время на вставку в начало: " + (end - start));

        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            javaList.addFirst(array[i]);
        }
        end = System.nanoTime();
        System.out.println("JavaLinkedList! Время на вставку в начало: " + (end - start));
        //---------------------------------------------------------------------------------------

        System.out.println();
        myList.clear();
        javaList.clear();

        //------------------------------Добавление в конец---------------------------------------
        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            myList.addLast(array[i]);
        }
        end = System.nanoTime();
        System.out.println("MyLinkedList! Время на вставку в конец: " + (end - start));

        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            javaList.addLast(array[i]);
        }
        end = System.nanoTime();
        System.out.println("JavaLinkedList! Время на вставку в конец: " + (end - start));
        //---------------------------------------------------------------------------------------

        System.out.println();
        myList.clear();
        javaList.clear();

        //------------------------------Добавление в случайное место---------------------------------------
        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            myList.add((int) (Math.random() * i), array[i]);
        }
        end = System.nanoTime();
        System.out.println("MyLinkedList! Время на вставку в рандомное место: " + (end - start));

        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            javaList.add((int) (Math.random() * i), array[i]);
        }
        end = System.nanoTime();
        System.out.println("JavaLinkedList! Время на вставку в рандомное место: " + (end - start));
        //---------------------------------------------------------------------------------------

        System.out.println();

        //------------------------------Удаление всех элементов---------------------------------------
        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            myList.remove((int) (Math.random() * myList.size()));
        }
        end = System.nanoTime();
        System.out.println("MyLinkedList! Время на удаление: " + (end - start));

        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            javaList.remove((int) (Math.random() * javaList.size()));
        }
        end = System.nanoTime();
        System.out.println("JavaLinkedList! Время на удаление: " + (end - start));
        //---------------------------------------------------------------------------------------
    }


    public void compareLists(int size) {

        ArrayList<Integer> aList = new ArrayList<>();
        LinkedList<Integer> lList = new LinkedList<>();

        int[] array = genMas(size);

        //------------------------------Вставка в конец---------------------------------------
        System.out.println("Вставка в конец");
        long start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            aList.add(array[j]);
        }
        long end = System.nanoTime();
        System.out.println("ArrayList: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            lList.add(array[j]);
        }
        end = System.nanoTime();
        System.out.println("LinkedList: " + (double) ((end - start) / 1_000_000.0));
        //---------------------------------------------------------------------------------------

        System.out.println();

        //------------------------------Вставка в начало---------------------------------------
        System.out.println("Вставка в начало");
        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            aList.add(0, array[j]);
        }
        end = System.nanoTime();
        System.out.println("ArrayList: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            lList.addFirst(array[j]);
        }
        end = System.nanoTime();
        System.out.println("LinkedList: " + (double) ((end - start) / 1_000_000.0));
        //---------------------------------------------------------------------------------------

        System.out.println();

        //------------------------------Вставка---------------------------------------
        System.out.println("Вставка");
        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            aList.add((int) (aList.size() * Math.random()), array[j]);
        }
        end = System.nanoTime();
        System.out.println("ArrayList: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            lList.add((int) (lList.size() * Math.random()), array[j]);
        }
        end = System.nanoTime();
        System.out.println("LinkedList: " + (double) ((end - start) / 1_000_000.0));
        //---------------------------------------------------------------------------------------

        System.out.println();

        //------------------------------Удаление из конца---------------------------------------
        System.out.println("Удаление из конца");
        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            aList.remove(aList.size() - 1);
        }
        end = System.nanoTime();
        System.out.println("ArrayList: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            lList.removeLast();
        }
        end = System.nanoTime();
        System.out.println("LinkedList: " + (double) ((end - start) / 1_000_000.0));
        //---------------------------------------------------------------------------------------

        System.out.println();

        //------------------------------Удаление из начала---------------------------------------
        System.out.println("Удаление из начала");
        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            aList.remove(0);
        }
        end = System.nanoTime();
        System.out.println("ArrayList: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            lList.removeFirst();
        }
        end = System.nanoTime();
        System.out.println("LinkedList: " + (double) ((end - start) / 1_000_000.0));
        //---------------------------------------------------------------------------------------

        System.out.println();

        //------------------------------Удаление---------------------------------------
        System.out.println("Удаление");
        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            aList.remove((int) (aList.size() * Math.random()));
        }
        end = System.nanoTime();
        System.out.println("ArrayList: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            lList.remove((int) (lList.size() * Math.random()));
        }
        end = System.nanoTime();
        System.out.println("ArrayList: " + (double) ((end - start) / 1_000_000.0));
        //---------------------------------------------------------------------------------------

        System.out.println();
    }

    public void compareSet(int size) {
        HashSet<Integer> hs = new HashSet<>();
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        TreeSet<Integer> ts = new TreeSet<>();

        int[] array = genMas(size);

        //------------------------------Вставка---------------------------------------
        System.out.println("Вставка");
        long start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            hs.add(array[j]);
        }
        long end = System.nanoTime();
        System.out.println("HashSet: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            lhs.add(array[j]);
        }
        end = System.nanoTime();
        System.out.println("LinkedHashSet: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            ts.add(array[j]);
        }
        end = System.nanoTime();
        System.out.println("TreeSet: " + (double) ((end - start) / 1_000_000.0));
        //---------------------------------------------------------------------------------------

        System.out.println();

        //------------------------------Удаление---------------------------------------
        System.out.println("Удаление");
        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            hs.remove(array[(int) (array.length * Math.random())]);
        }
        end = System.nanoTime();
        System.out.println("HashSet: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            lhs.remove(array[(int) (array.length * Math.random())]);
        }
        end = System.nanoTime();
        System.out.println("LinkedHashSet: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            ts.remove(array[(int) (array.length * Math.random())]);
        }
        end = System.nanoTime();
        System.out.println("TreeSet: " + (double) ((end - start) / 1_000_000.0));
        //---------------------------------------------------------------------------------------

        System.out.println();

        //------------------------------Поиск---------------------------------------
        System.out.println("Поиск");
        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            hs.contains(array[(int) (array.length * Math.random())]);
        }
        end = System.nanoTime();
        System.out.println("HashSet: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            lhs.contains(array[(int) (array.length * Math.random())]);
        }
        end = System.nanoTime();
        System.out.println("LinkedHashSet: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            ts.contains(array[(int) (array.length * Math.random())]);
        }
        end = System.nanoTime();
        System.out.println("TreeSet: " + (double) ((end - start) / 1_000_000.0));
        //---------------------------------------------------------------------------------------

        System.out.println();
    }

    public void compareMap(int size) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        int[] array = genMas(size);

        //------------------------------Вставка---------------------------------------
        System.out.println("Вставка");
        long start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            hm.put(array[j], array[j]);
        }
        long end = System.nanoTime();
        System.out.println("HashMap: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            lhm.put(array[j], array[j]);
        }
        end = System.nanoTime();
        System.out.println("LinkedHashMap: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            tm.put(array[j], array[j]);
        }
        end = System.nanoTime();
        System.out.println("TreeMap: " + (double) ((end - start) / 1_000_000.0));
        //---------------------------------------------------------------------------------------

        System.out.println();

        //------------------------------Удаление---------------------------------------
        System.out.println("Удаление");
        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            hm.remove(array[(int) (array.length * Math.random())]);
        }
        end = System.nanoTime();
        System.out.println("HashMap: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            lhm.remove(array[(int) (array.length * Math.random())]);
        }
        end = System.nanoTime();
        System.out.println("LinkedHashMap: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            tm.remove(array[(int) (array.length * Math.random())]);
        }
        end = System.nanoTime();
        System.out.println("TreeMap: " + (double) ((end - start) / 1_000_000.0));
        //---------------------------------------------------------------------------------------

        System.out.println();

        //------------------------------Поиск---------------------------------------
        System.out.println("Поиск");
        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            hm.containsKey(array[(int) (array.length * Math.random())]);
        }
        end = System.nanoTime();
        System.out.println("HashMap: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            lhm.containsKey(array[(int) (array.length * Math.random())]);
        }
        end = System.nanoTime();
        System.out.println("LinkedHashMap: " + (double) ((end - start) / 1_000_000.0));

        start = System.nanoTime();
        for (int j = 0; j < size; j++) {
            tm.containsKey(array[(int) (array.length * Math.random())]);
        }
        end = System.nanoTime();
        System.out.println("TreeMap: " + (double) ((end - start) / 1_000_000.0));
        //---------------------------------------------------------------------------------------

        System.out.println();
    }
}
