package com.algorithm.vincent.rootofx;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class BinaryDivided {
    public static void main(String[] args) {
        System.out.println(458753 * 458753);
        System.out.println(requestRootIntegerPart(1000000));
    }

    public static long requestRootIntegerPart(long num){
        long lowerBound = 2;
        long upperBound = num - 1;
        long mid = (lowerBound + upperBound) / 2;
        while(!(mid * mid <= num && (mid + 1) * (mid + 1) > num)){
            if( mid * mid > num){
                upperBound = mid;
                mid = (lowerBound + upperBound) / 2;
            }else if( mid * mid < num){
                lowerBound = mid ;
                mid = (lowerBound + upperBound) / 2;
            }
            System.out.println(lowerBound + " " + mid + " "+ upperBound);
        }
        return mid;
    }
}
