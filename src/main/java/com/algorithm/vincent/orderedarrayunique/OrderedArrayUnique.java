package com.algorithm.vincent.orderedarrayunique;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class OrderedArrayUnique {
    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2,3,3,4,4,5,5,6};
        int[] test2 = new int[]{1, 2,3,3,4,4,5,5,6, 8, 10};
        int[] test3 = new int[]{1, 2,3,3,3,3,3,3,3};
        System.out.println(getLength(test1));
        System.out.println(getLength(test2));
        System.out.println(getLength(test3));
    }

    public static  int getLength(int[] array){
        if(array == null || array.length < 1){
            return 0;
        }
        if(array.length == 1){
            return 1;
        }
        int slowIndex = 0;
        int fastIndex = 1;
        while(fastIndex != array.length){
            if(array[slowIndex] == array[fastIndex]){
                fastIndex++;
            }else{
                slowIndex++;
                int tmp = array[slowIndex];
                array[slowIndex] = array[fastIndex];
                fastIndex++;
            }

        }
        return slowIndex + 1;
    }
}
