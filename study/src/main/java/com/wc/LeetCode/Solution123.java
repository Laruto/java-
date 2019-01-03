package com.wc.LeetCode;

import org.junit.Test;

/** Best Time to Buy and Sell Stock III
 * 解法：动态规划
 * 递推公式：f(k,i) = max(f(k,i-1),f(k-1,j)-prices[j]+prices[i]) j in range [0,i)  注意到prices[i]是不变的 用tmpMax存储f(k-1,j)-prices[j]
 * Created by WC on 2019/1/3
 */

public class Solution123 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[][] array = new int[2+1][prices.length];

        for (int k = 1; k <= 2; k++) {
            int max = 0;
            int tmpMax = -prices[0];                           //用来存放买入的最小值
            for (int i = 1; i < prices.length; i++) {
                /*for (int j = 0; j < i ; j++)
                    max = Math.max(prices[i] - prices[j] + array[k-1][j], max);  //使用了最后一项
                array[k][i] = Math.max(max, array[k][i-1]);                       //没有使用最后一项*/

                max = Math.max(prices[i] + tmpMax, max);  //使用了最后一项
                array[k][i] = Math.max(max, array[k][i-1]);   //没有使用最后一项
                tmpMax = Math.max(tmpMax,array[k-1][i]-prices[i]);
            }
        }

        return array[2][prices.length - 1];
    }

    @Test
    public void test(){
        int[] a = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(a));
    }
}
