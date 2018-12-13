package com.wc.nowcoder;

import org.junit.Test;

/**二叉搜索树的后序遍历序列
 * Created by WC on 2018/12/13
 */

public class Solution33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0){   //不能用squence==null ！！！
            return false;
        }
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }

    public boolean VerifySquenceOfBST(int [] a,int x,int y){
        if(x==y)
            return true;
        int px = x;
        int root = a[y];
        while (a[px]<root)
            px++;
        if(px==y)
            return VerifySquenceOfBST(a,x,px-1);
        else if(px==x)
        {
            if(greaterRoot(a,px,y-1,root)){
                return VerifySquenceOfBST(a,px,y-1);
            }
        }
        if(greaterRoot(a,px,y-1,root))
            return VerifySquenceOfBST(a,x,px-1)&&VerifySquenceOfBST(a,px,y-1);
        else
            return false;
    }

    public boolean greaterRoot(int[] a,int x,int y,int root){
        boolean result = true;
        for (int i = x;i<=y;i++){
            if(a[i]<=root) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] a = null;
        System.out.println(VerifySquenceOfBST(a));
    }
}


/*public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;
        if(sequence.length==1)
            return true;
        return ju(sequence, 0, sequence.length-1);

    }

    public boolean ju(int[] a,int star,int root){
        if(star>=root)
            return true;
        int i = root;
        //从后面开始找
        while(i>star&&a[i-1]>a[root])
            i--;//找到比根小的坐标
        //从前面开始找 star到i-1应该比根小
        for(int j = star;j<i-1;j++)
            if(a[j]>a[root])
                return false;;
        return ju(a,star,i-1)&&ju(a, i, root-1);
    }
}*/
