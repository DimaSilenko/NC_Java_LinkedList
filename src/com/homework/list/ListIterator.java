package com.homework.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<E> implements Iterator<E> {

    private Node<E> curNode;
    private Node<E> previous;

    public ListIterator(Node<E> curNode) {
        this.curNode = curNode;
        this.previous = null;
    }

    @Override
    public boolean hasNext() {
        return curNode != null;
    }

    @Override
    public E next() {
        if (curNode == null)
            throw new NoSuchElementException();
        E ans = curNode.getElement();
        previous = curNode;
        curNode = curNode.getNextNode();
        return ans;
    }
}
