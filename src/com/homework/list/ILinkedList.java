package com.homework.list;

public interface ILinkedList<E> extends Iterable<E> {

    void addFirst(E element);

    void addLast(E element);

    void add(int index, E element);

    void clear();

    E get(int index);

    int indexOf(E element);

    E remove(int index);

    E set(int index, E element);

    int size();

    E[] toArray(E[] a);

    String toString();

}
