package com.caliburn.algorithm.list.stack;

/**
 * 堆栈
 * @param <ITEM>
 */
public interface IStack<ITEM> extends Iterable<ITEM>{

    void push(ITEM item);

    ITEM pop();

    boolean isEmpty();

    int size();

}
