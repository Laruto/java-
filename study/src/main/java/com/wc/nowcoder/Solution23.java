package com.wc.nowcoder;

import org.junit.Test;

public class Solution23 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null)
            return null;
        ListNode startNode = haveLoop(pHead);
        if(startNode==null)
            return null;
        ListNode p = startNode.next;
        int i = 1;
        while (p!=startNode){
            p = p.next;
            i++;
        }
        ListNode p1 = pHead,p2 = p1;
        for(;i>0;i--){
            p2 = p2.next;
        }
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public ListNode haveLoop(ListNode pHead){
        ListNode slowNode = pHead,fastNode = pHead.next;
        while (fastNode!=null){
            if(slowNode==fastNode){
                return fastNode;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if(fastNode!=null)
                fastNode = fastNode.next;
        }
        return null;
    }

    @Test
    public void test(){
//        ListNode l = new ListNode(1);
////        l.add(2);
////        l.add(3);
////        ListNode p = l.next.next;
////        p.next = l;
////       ListNode j = new ListNode(0);
////       j.next = l;
////        ListNode result = EntryNodeOfLoop(j);
        ListNode p = new ListNode(1);
        ListNode result = EntryNodeOfLoop(p);
        System.out.println(result.val);
    }
}
