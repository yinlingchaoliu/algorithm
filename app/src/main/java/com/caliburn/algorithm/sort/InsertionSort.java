package com.caliburn.algorithm.sort;

/**
 * 插入排序
 * <p>
 * 将一个元素插入有序数组适当位置
 */
public class InsertionSort extends AbstractSort {

    @Override
    public void sort(Comparable[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {

            //将array[i] 插入到array[i-1],array[i-2],array[i-3]...中
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                exch(array, j, j - 1);
            }

        }

    }

}
