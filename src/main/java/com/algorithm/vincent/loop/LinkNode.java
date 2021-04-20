package com.algorithm.vincent.loop;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class LinkNode {

    int data;
    public LinkNode(int data){
        this.data = data;
    }
    private LinkNode next;

    public LinkNode getNext() {
        return next;
    }

    public LinkNode setNext(LinkNode next) {
        this.next = next;
        return next;
    }

    public boolean hasNext(){
        if(this.next != null){
            return true;
        }else{
            return false;
        }
    }

    public int getData() {
        return data;
    }

    public LinkNode setData(int data) {
        this.data = data;
        return this;
    }
}
