package com.caliburn.algorithm.sort;

/**
 * 希尔排序
 * 思想：数组中任意间隔为h的元素是有序的
 * 重点研究一下
 */
public class ShellSort extends AbstractSort {

    @Override
    public void sort(Comparable[] array) {
        int N = array.length;
        int h = 1;
        //h为N的1/3+1
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {

            //将数组变为h有序
            for (int i = h; i < N; i++) {
                //将a[i]插入到a[i-h],a[i-2h],a[i-3h]...之中
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
                    exch(array, j, j - h);
                }
            }
            h = h / 3;
        }

    }

}
