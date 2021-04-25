package com.homework.list;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyLinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    private Node<E> find (int index) {
        Node<E> curNode;
        if (size / 2 - index >= 0) {
            curNode = first;
            for (int i = 0; i < index; i++) {
                curNode = curNode.getNextNode();
            }
        }
        else {
            curNode = last;
            for (int i = 0; i < (size - 1) - index; i++) {
                curNode = curNode.getPreviousNode();
            }
        }
        return curNode;
    }

    private boolean check(int index) {
        if (size == 0 || index < 0 || index >= size) {
            System.out.println("Неверный индекс, размер списка: " + size + " (индексация с нуля)");
            return false;
        }
        return true;
    }


    @Override
    public void addFirst(E element) {
        if (element == null) {
            System.out.println("Нельзя добавлять null!");
            return;
        }
        if (size == 0) {
            first = new Node<>(element);
            last = first;
        }
        else {
            first.setPreviousNode(new Node<>(element, null, first));
            first = first.getPreviousNode();
        }
        size++;
    }

    @Override
    public void addLast(E element) {
        if (element == null) {
            System.out.println("Нельзя добавлять null!");
            return;
        }
        if (size == 0) {
            first = new Node<>(element);
            last = first;
        } else {
            last.setNextNode(new Node<>(element, last, null));
            last = last.getNextNode();
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (element == null) {
            System.out.println("Нельзя добавлять null!");
            return;
        }
        if (size == 0 && index == 0) {
            addFirst(element);
            return;
        }

        if (index < 0 || index >= size) {
            System.out.println("Неверный индекс, размер списка: " + size + " (индексация с нуля)");
            return;
        }

        if (index == 0) {
            addFirst(element);
            return;
        }

        if (index == size - 1) {
            addLast(element);
            return;
        }

        Node<E> curNode = find(index);

        curNode.getPreviousNode().setNextNode(new Node<>(element, curNode.getPreviousNode(), curNode));
        curNode.setPreviousNode(curNode.getPreviousNode().getNextNode());
        size++;
        return;
    }

    @Override
    public void clear() {
        Node<E> curNode = first;
        Node<E> next;
        for (int i = 0; i < size; i++) {
            next = curNode.getNextNode();

            curNode.setPreviousNode(null);
            curNode.setElement(null);
            curNode.setNextNode(null);
            curNode = next;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        if(!check(index)) {
            return null;
        }

        if (index == 0) {
            return first.getElement();
        }

        if (index == size - 1) {
            return last.getElement();
        }

        return find(index).getElement();
    }

    @Override
    public int indexOf(E element) {
        if (size == 0) {
            System.out.println("Список пуст!");
            return -1;
        }

        Node<E> curNode = first;
        for (int i = 0; i < size; i++) {
            if (curNode.getElement().equals(element)) {
                return i;
            }
            curNode = curNode.getNextNode();
        }

        System.out.println("Элемент не найден!");
        return -1;
    }

    @Override
    public E remove(int index) {
        if (!check(index)) {
            return null;
        }

        Node<E> curNode;

        if (index == 0) {
            curNode = first;
            first = first.getNextNode();
            if (first != null)
                first.setPreviousNode(null);
            size--;
            return curNode.getElement();
        }

        if (index == size - 1) {
            curNode = last;
            last = last.getPreviousNode();
            last.setNextNode(null);
            size--;
            return curNode.getElement();
        }

        curNode = find(index);
        curNode.getPreviousNode().setNextNode(curNode.getNextNode());
        curNode.getNextNode().setPreviousNode(curNode.getPreviousNode());
        curNode.setPreviousNode(null);
        curNode.setNextNode(null);
        size--;

        return curNode.getElement();
    }

    @Override
    public E set(int index, E element) {
        if (element == null) {
            System.out.println("Нельзя добавлять null!");
            return null;
        }

        if (!check(index)) {
            return null;
        }

        if (index == 0) {
            first.setElement(element);
            return first.getElement();
        }

        if (index == size - 1) {
            last.setElement(element);
            return last.getElement();
        }

        Node<E> curNode = find(index);

        curNode.setElement(element);
        return curNode.getElement();
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray(E[] a) {
        if (a.length < size)
            a = (E[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);

        Node<E> curNode = first;
        for (int i = 0; i < size; i++) {
            a[i] = curNode.getElement();
            curNode = curNode.getNextNode();
        }

        if (a.length > size)
            a[size] = null;

        return a;
    }

    @Override
    public String toString() {
        StringBuilder listStr = new StringBuilder("");
        if (size == 0) {
            listStr.append("Список пуст!");
            return listStr.toString();
        }

        Node<E> temp = first;
        int i = 0;
        while (temp != null) {
            listStr.append(i + ") " + temp.getElement().toString() + "; ");
            i++;
            temp = temp.getNextNode();
        }
        return listStr.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(first);
    }
}
