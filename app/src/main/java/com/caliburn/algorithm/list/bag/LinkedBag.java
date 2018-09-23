package com.caliburn.algorithm.list.bag;

import java.util.Iterator;

public class LinkedBag<ITEM> implements IBag<ITEM> {

    private Node firstNode = null;
    private int N = 0;

    @Override
    public void add(ITEM item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = firstNode;
        firstNode = newNode;
        N++;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<ITEM> iterator() {
        return new ReverseLinkedIterator();
    }

    private class ReverseLinkedIterator implements Iterator<ITEM> {
        private Node currentNode = firstNode;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public ITEM next() {
            if (currentNode == null) return null;
            ITEM item = currentNode.item;
            currentNode = currentNode.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    /**
     * 链表节点
     */
    private class Node {
        ITEM item;
        Node next;
    }

}
