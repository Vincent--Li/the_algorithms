package com.algorithm.vincent.blockingstatedependent;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    public GrumpyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws BufferFullException {
        if(isFull()){
            throw new BufferFullException();
        }
        doPut(v);
    }

    public synchronized V take() throws BufferEmptyException {
        if(isEmpty()){
            throw new BufferEmptyException();
        }
        return doTake();
    }
}
