package com.algorithm.vincent.dynamicprogramming;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class CanWin {
    public static void main(String[] args) {

    }

    static boolean dp(int[] arr){
        int length = arr.length;

        int[] dp = new int[length];
        for(int i = 0; i < length; i++){
            dp[i] = arr[i];
        }

        for(int i = length - 2; i >=0; i--){
            for(int j = i + 1; j < length; j++ ){
                dp[j] = Math.max(arr[i] - dp[j], arr[j] - dp[j-1]);
            }
        }
        return dp[length - 1] >= 0;
    }
}
