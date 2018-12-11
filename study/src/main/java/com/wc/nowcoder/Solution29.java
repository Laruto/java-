package com.wc.nowcoder;

import org.junit.Test;

import java.util.ArrayList;

/**顺时针打印矩阵
 * Created by WC on 2018/12/11
 */

public class Solution29 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int row = matrix.length,col = matrix[0].length;
        if(row==0||col==0)
            return result;
        int layer = (Math.min(row,col)+1)/2;
        for(int i = 0;i<layer;i++){
            for(int k = i;k<col-i;k++)
                result.add(matrix[i][k]);
            for(int k = i+1;k<row-i;k++)
                result.add(matrix[k][col-i-1]);
            for(int k = col-2-i;(k>=i)&&(2*i+1!=row);k--)       //记得判断只有一行的情况
                result.add(matrix[row-1-i][k]);
            for(int k = row-2-i;(k>i)&&(2*i+1!=col);k--)        //同理，只有一列的情况
                result.add(matrix[k][i]);
        }
        return  result;
    }

    @Test
    public void test(){
        ArrayList<Integer> a = printMatrix(new int[][]{{1},{2},{3},{4},{5}});
        System.out.println(a);
    }

}
