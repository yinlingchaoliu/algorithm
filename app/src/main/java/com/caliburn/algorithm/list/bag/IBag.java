package com.caliburn.algorithm.list.bag;

/**
 * 背包
 * @param <ITEM>
 */
public interface IBag<ITEM> extends Iterable<ITEM> {

    void add(ITEM item);

    boolean isEmpty();

    int size();

}
