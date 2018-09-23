package com.caliburn.algorithm.sort;

/**
 * 抽象模板
 */
public abstract class AbstractSort implements ISort {

    @Override
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    @Override
    public void exch(Comparable[] array, int i, int j) {
        Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //是否有序
    @Override
    public boolean isSorted(Comparable[] array) {
        int length = array.length;
        for(int i = 1 ; i< length;i++){
            if(less(array[i],array[i-1])) return false;
        }
        return true;
    }
}