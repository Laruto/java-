package com.wc.nowcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**从上到下打印二叉树
 * Created by WC on 2018/12/12
 */

public class Solution32 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();     //LinkedList实现了Queue接口，所以可以直接使用
        if(root==null)
            return result;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode p = queue.remove();
            result.add(p.val);
            if(p.left!=null)
                queue.offer(p.left);
            if(p.right!=null)
                queue.offer(p.right);
        }

        return result;
    }


}
