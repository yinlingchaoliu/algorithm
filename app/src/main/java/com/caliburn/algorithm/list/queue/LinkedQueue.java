package com.caliburn.algorithm.list.queue;

import java.util.Iterator;

public class LinkedQueue<ITEM> implements IQueue<ITEM> {

    private int N = 0;
    private Node firstNode = null;
    private Node lastNode = null;


    @Override
    public void enqueue(ITEM item) {

        if (firstNode == null) {
            firstNode = new Node();
            firstNode.item = item;
            firstNode.next = null;
            lastNode = firstNode;
            return;
        }

        //创建新节点
        Node nextNode = new Node();
        nextNode.item = item;
        nextNode.next = null;

        lastNode.next = nextNode;
        lastNode = nextNode;
        N++;
    }

    /**
     * 取出头
     *
     * @return
     */
    @Override
    public ITEM dequeue() {
        if (firstNode == null) return null;
        ITEM item = firstNode.item;
        firstNode = firstNode.next;
        N--;
        if (firstNode == null) {
            lastNode = null;
            N = 0;
        }
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