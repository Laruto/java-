package com.wc.nowcoder;

/**
 * Created by WC on 2018/12/9
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

}
