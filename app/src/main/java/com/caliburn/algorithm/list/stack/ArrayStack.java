package com.caliburn.algorithm.list.stack;

import java.util.Iterator;

/**
 * 堆栈
 *
 * @param <ITEM>
 */
public class ArrayStack<ITEM> implements IStack<ITEM> {

    private ITEM[] array = (ITEM[]) new Object[1];
    private int N = 0;

    @Override
    public void push(ITEM item) {
        if (N == array.length) {
            resize(2 * N);
        }
        array[N++] = item;
    }

    @Override
    public ITEM pop() {
        ITEM item = array[--N];
        array[N] = null;
        if (N > 0 && N == array.length / 4) {
            resize(N / 2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<ITEM> iterator() {
        return new ReverseArrayIterator();
    }

    /**
     * 数组扩容
     * 2倍扩容
     *
     * @param max
     */
    private void resize(int max) {
        ITEM[] temp = (ITEM[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }


    private class ReverseArrayIterator implements Iterator<ITEM> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public ITEM next() {
            return array[--i];
        }

        @Override
        public void remove() {

        }
    }

}
