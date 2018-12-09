package com.wc.nowcoder;


import org.junit.Test;

/**
 * Created by WC on 2018/12/9
 */

public class Solution26 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        Boolean result = false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val){
                result = DoesTree1HaveTree2(root1,root2);
            }
            if(!result)
                result = HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);

        }
        return result;
    }

    public boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return DoesTree1HaveTree2(root1.left,root2.left)&&DoesTree1HaveTree2(root1.right,root2.right);
    }

    @Test
    public void test(){

    }
}
