package com.wc.nowcoder;

import org.junit.Test;

import java.util.Stack;

/**栈的压入，弹出序列
 * Created by WC on 2018/12/12
 */

public class Solution31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0)
            return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0;i<pushA.length;i++) {
            stack.push(pushA[i]);

            while(!stack.empty()&&stack.peek() == popA[index]){
                stack.pop();
                index++;
            }
        }

        return stack.empty();
    }

    @Test
    public void test(){
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};
        IsPopOrder(a,b);
    }
}
