package com.wc.nowcoder;

/**
 * Created by WC on 2018/12/9
 */

public class Solution27 {
    public void Mirror(TreeNode root) {
        if(root==null)
            return;

        if (root.left==null){
            Mirror(root.right);
            root.left = root.right;
            root.right = null;
            return;
        }

        Mirror(root.left);
        Mirror(root.right);
        TreeNode p = root.left;
        root.left = root.right;
        root.right = p;
    }
}
