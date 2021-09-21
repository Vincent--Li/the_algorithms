package com.algorithm.vincent.algorithms.maxmultiplyresult;

import java.util.Set;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class MaxMultiply {
    public static void main(String[] args) {
        long[] tc1 = new long[]{ 1L, 2L, 3L, 4L};
        long[] tc2 = new long[]{ 1L, 2L, - 3L, - 4L, -5L};
        long[] tc3 = new long[]{ -1L, -2L, - 3L, - 4L, -5L};

        System.out.println(getMaxMultiply(tc1));
        System.out.println(getMaxMultiply(tc2));
        System.out.println(getMaxMultiply(tc3));


    }

    public static long getMaxMultiply(long[] nums){
        // max1 > max2 > max3
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        // min1 < min2
        long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;
        for( int i = 0; i < nums.length; i ++){
            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if (nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i] > max3){
                max3 = nums[i];
            }

            if(nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            } else if ( nums[i] < min2){
                min2 = nums[i];
            }
        }

        Set<String> test;

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
