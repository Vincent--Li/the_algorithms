package com.algorithm.vincent.middleindex;

import java.util.Arrays;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class MiddleIndex {
    public static void main(String[] args) {
        int[] tc1 = new int[]{1,-2, 3, -4, 2, 3};
        int[] tc2 = new int[]{1, 7, 3, 6, 5, 6};

        System.out.println(findMiddleIndex(tc1));
        System.out.println(findMiddleIndex(tc2));
    }

    public static int findMiddleIndex(int nums[]){
        int total = 0;
        int sum = Arrays.stream(nums).sum();
        for(int totalIndex = 0; totalIndex < nums.length; totalIndex++){
            total += nums[totalIndex];
            if((total - nums[totalIndex]) * 2 == (sum - nums[totalIndex])){
                return totalIndex;
            }
        }
        return -1;
    }
}
