package com.caliburn.algorithm.sort;

/**
 * 选择排序
 * 逻辑：先找到数组最小的元素，交换位置
 * 其次找剩下最小的元素，再交换位置
 * 直到结束
 *
 * @author chentong
 */
public class SelectionSort extends AbstractSort {

    @Override
    public void sort(Comparable[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            //将array[i]和array[i+1 ... N]中最小元素交换
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(array[j], array[min])) {
                    min = j;
                }
            }
            exch(array, i, min);
        }
    }

}
