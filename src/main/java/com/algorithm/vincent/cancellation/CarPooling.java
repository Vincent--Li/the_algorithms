package com.algorithm.vincent.cancellation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class CarPooling {
    public static void main(String[] args) {
        int[][] trips = new int[][]{{2, 3, 7}, {2, 1,5}};
        int initCapacity = 4;
        int currentCustomers = 0;

        Map<Integer, Integer> locationMergeNumbers = new HashMap<>();
        for(int[] trip : trips){
            locationMergeNumbers.put(trip[1] - 1,  trip[0] + new Integer(locationMergeNumbers.get(trip[1] - 1) != null?locationMergeNumbers.get(trip[1] - 1):0));
            locationMergeNumbers.put(trip[2] - 1,  trip[0] - new Integer(locationMergeNumbers.get(trip[2] - 1) != null?locationMergeNumbers.get(trip[2] - 1):0));
        }
        for(Map.Entry<Integer,Integer> numberOfEachTrip: locationMergeNumbers.entrySet()){
            System.out.println(currentCustomers);
            System.out.println(numberOfEachTrip.getValue());
            if(currentCustomers + numberOfEachTrip.getValue() > initCapacity){
                System.out.println(false);
                return;
            }
            currentCustomers += numberOfEachTrip.getValue();
        }
        System.out.println(true);
    }

}
