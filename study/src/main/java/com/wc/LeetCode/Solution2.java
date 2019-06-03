package com.wc.LeetCode;

/**
 * Created by WC on 2018/12/6
 */


import org.junit.Test;
import org.w3c.dom.ls.LSException;

import java.util.List;



public class Solution2<asd> {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode p1=l1,p2=l2,h=result;
        int carry = 0;
        while (p1!=null||p2!=null){
            int x = (p1!=null)?p1.val:0;
            int y = (p2!=null)?p2.val:0;
            int sum = x+y+carry;
            carry = sum/10;
            h.next = new ListNode(sum%10);
            if(p1!=null) p1=p1.next;
            if(p2!=null) p2=p2.next;
            h = h.next;
        }
        if(carry > 0)
            h.next = new ListNode(1);
        return result.next;
    }

    @Test
    public void test(){
        ListNode p1 = new ListNode(2);
        p1.add(4);
        p1.add(3);
        ListNode p2 = new ListNode(5);
        p2.add(6);
        p2.add(4);
        ListNode result = addTwoNumbers(p1,p2);
        result.print();
    }

    
}
