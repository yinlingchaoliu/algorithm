package com.caliburn.algorithm.list.stack;

import java.util.Iterator;

/**
 * @author chentong
 * 链表stack
 * @param <ITEM>
 */
public class LinkedStack<ITEM> implements IStack<ITEM> {

    private int N = 0;
    //首个元素
    private Node firstNode = null;

    @Override
    public void push(ITEM item) {
        Node nextNode = firstNode;
        firstNode = new Node();
        firstNode.item = item;
        firstNode.next = nextNode;
        N++;
    }

    @Override
    public ITEM pop() {
        if (firstNode == null) return null;
        ITEM item = firstNode.item;
        firstNode = firstNode.next;
        N--;
        return item;
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
        private int i = N;
        private Node currentNode = firstNode;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public ITEM next() {
            if (currentNode == null) return null;
            ITEM item = currentNode.item;
            currentNode = currentNode.next;
            i--;
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
