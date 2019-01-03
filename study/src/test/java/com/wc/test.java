package com.wc;

import org.junit.Test;


/**
 * Created by WC on 2018/12/14
 */

public class test {
    public int reverse(int x) {

        int result = 0;
        while(x!=0){
            int tail = x%10;
            int newResult = result*10+tail;
            x = x/10;
            if((newResult-tail)/10!=result)
                return 0;
            result = newResult;
        }

        return result;

    }

    @Test
    public void test(){
        System.out.println(reverse(123));
    }
}
