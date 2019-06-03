package com.wc.LeetCode;

/**
 * Created by WC on 2018/12/6
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public void add(int x){
        ListNode p = this;
        while (p.next!=null)
            p = p.next;
        p.next = new ListNode(x);
    }

    public void print(){
        ListNode p = this;
        while(p!=null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    public ListNode(int[] num){
        this.val = num[0];
        for (int i = 1; i < num.length; i++) {
            this.add(num[i]);
        }
    }


}
