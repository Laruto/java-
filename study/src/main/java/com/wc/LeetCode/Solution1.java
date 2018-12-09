package com.wc.LeetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WC on 2018/12/6
 */

public class Solution1 {
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

   @Test
    public void test(){
        int[] a = {1,2,3,4,5,6};
        int[] b = twoSum(a,66);
        for(int s:b)
            System.out.println(s);
    }

}
