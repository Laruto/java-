package com.wc.LeetCode;

import java.util.ArrayList;

/**
 * Created by WC on 2018/12/18
 */

public class Test {
    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    @org.junit.Test
    public void tests(){
        System.out.println(maxSubArray(new int[]{-2, 1,-3,4,-1,2,1,-5,4}));
    }
}
