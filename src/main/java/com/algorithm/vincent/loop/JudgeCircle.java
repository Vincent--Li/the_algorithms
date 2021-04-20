package com.algorithm.vincent.loop;

import java.security.PublicKey;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class JudgeCircle {

    public static int LINK_LENGTH = 1000;

    public static void main(String[] args) {

        for(int i = 1; i < LINK_LENGTH; i ++){
            LinkNode header = constructALoop(i);
            Integer step = judgeHasLoop(header);
            System.out.println("find loop (jointPoint, step): ("+ i + "," + step + ")");
        }
    }

    public static Integer judgeHasLoop(LinkNode header){
        int slowStep = 0;
        while(true){
            slowStep++;
            LinkNode slowPointer = retrieveNode(header, slowStep);
            LinkNode quickPointer = retrieveNode(header, slowStep * 2);
            if(slowPointer == quickPointer){
//                System.out.println("find loop at slowStep: " + slowStep + " and slowData is : " + slowPointer.getData() + " and quickData is : " + quickPointer.getData());
                return slowStep;
            }
            if(slowPointer == null || quickPointer == null){
//                System.out.println("did not find loop");
                return null;
            }
        }
    }

    public static LinkNode retrieveNode(LinkNode header, Integer steps){
        LinkNode result = header;
        int i = 0;
        for(; i < steps; i++){
            if(result.hasNext()){
                result = result.getNext();
            }else{
                break;
            }
        }

        if(i == steps){
            return result;
        }
        return null;
    }

    public static LinkNode constructALoop(int jointPoint){
        LinkNode header = new LinkNode(0);
        LinkNode tmp = header;
        for(int i = 1; i< LINK_LENGTH; i++){
            tmp = tmp.setNext(new LinkNode(i));
        }

        tmp.setNext(retrieveNode(header, jointPoint));
        return header;
    }
}
