package com.wc.nowcoder;

public class Solution19 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null||pHead.next == null){
            return pHead;
        }

        if(pHead.val == pHead.next.val){
            ListNode pNode = pHead.next;
            while(pNode!=null&&pNode.val==pHead.val){   //先判断是否为空，否则报指针为空的错误
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        }
        else{
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
