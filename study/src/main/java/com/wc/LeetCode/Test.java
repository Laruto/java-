package com.wc.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by WC on 2018/12/18
 */

public class Test {
    public ListNode detectCycle(ListNode head) {
        ListNode node = hasCycle(head);
        if (node == null)
            return null;

        ListNode pNode = node.next;
        ListNode p1 = head,p2 = p1.next;
        while (pNode != node){
            pNode = pNode.next;
            p2 = p2.next;
        }

        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    public ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head,fast = head.next;
        while (fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return slow;
        }

        return null;
    }

    @org.junit.Test
    public void test(){
        ListNode start = new ListNode(1);
        ListNode p = new ListNode(2);
        start.next = p;
        p.next = start;
        System.out.println(hasCycle(start).val);
    }

}
