package com.caliburn.algorithm.list.queue;

/**
 * 队列
 * @param <ITEM>
 */
public interface IQueue<ITEM> extends Iterable<ITEM>{

    void enqueue(ITEM item);

    ITEM dequeue();

    boolean isEmpty();

    int size();
}
