package com.wc.LeetCode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by WC on 2018/12/6
 */

public class Solution1 {

    public String reverseWords(String s) {
        if (s.length() == 0)
            return s;

        String res = "";
        StringBuilder cache = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (cache.length() > 0) {
                    res = cache.toString() + " " + res;
                    cache.setLength(0);
                }
            } else {
                cache.append(s.charAt(i));
            }
        }
        if (cache.length() > 0) {
            res = cache.toString() + " " + res;
        }

        if (res.length() == 0)
            return res;
        return res.substring(0,res.length() - 1);
        s.split()
    }

    @Test
    public void test(){
        System.out.println(reverseWords("a good   example"));
    }

}
