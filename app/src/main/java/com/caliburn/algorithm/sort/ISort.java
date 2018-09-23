package com.caliburn.algorithm.sort;

/**
 * 排序算法API
 * @author chentong
 *
 */
public interface ISort {

    //排序
    void sort(Comparable[] array);

    //比较
    boolean less(Comparable v, Comparable w);

    //交换
    void exch(Comparable[] array , int i, int j);

    //验证顺序
    boolean isSorted(Comparable[] array);
}
