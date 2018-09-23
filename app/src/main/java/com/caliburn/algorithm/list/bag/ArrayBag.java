package com.caliburn.algorithm.list.bag;

import java.util.Iterator;

public class ArrayBag<ITEM> implements IBag<ITEM> {

    private ITEM[] array = (ITEM[]) new Object[1];
    private int N = 0;

    @Override
    public void add(ITEM item) {
        if (N == array.length) {
            resize(2 * N);
        }
        array[N++] = item;
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
