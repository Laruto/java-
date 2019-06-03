package com.wc.LeetCode;

/**
 * Created by WC on 2018/12/9
 */

public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    public TreeNode(int[] num) {

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length - 1;
        return buildTree(preorder,0,n,inorder,0,n);
    }

    public static TreeNode buildTree(int[] preorder,int preStart,int preEnd, int[] inorder,int inStart,int inEnd) {
        if(preEnd > preorder.length - 1 || preEnd < preStart)
            return null;
        if(preStart == preEnd)
            return new TreeNode(preorder[preStart]);
        int leftLength = 0;
        while(inorder[inStart+leftLength]!=preorder[preStart])
            leftLength++;
        TreeNode result = new TreeNode(preorder[preStart]);
        result.left = buildTree(preorder,preStart+1,preStart+leftLength,inorder,inStart,inStart+leftLength-1);
        result.right = buildTree(preorder,preStart+leftLength+1,preEnd,inorder,inStart+leftLength+1,inEnd);
        return result;
    }
}