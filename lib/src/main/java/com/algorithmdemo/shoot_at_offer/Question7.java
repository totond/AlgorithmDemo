package com.algorithmdemo.shoot_at_offer;

import java.util.LinkedList;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/06
 * desc   : 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class Question7 {
    /**
     * 测试辅助算法：分层遍历二叉树，使用一个队列，也就是宽度优先遍历
     * @param root
     */
    public static void levelTraversal(TreeNode root){
        if(root==null)
            return ;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            System.out.print(cur.val+" ");
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);

        }
    }

    public static void main(String[] args) {
        //前序遍历{1,2,4,7,3,5,6,8} & 中序遍历序列{4,7,2,1,5,3,8,6}
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        // 重建二叉树后，使用宽度遍历进行输出测试
        levelTraversal(reConstructBinaryTree(pre,in));


    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }
        return constructNode(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    //使用递归的方法，先通过前序遍历确认根结点的位置，然后再分区递归处理
    private static TreeNode constructNode(int[] pre, int pStart, int pEnd, int[] in, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd){
            System.out.println("null in start");
            return null;
        }
        int rootValue = pre[pStart];
        TreeNode root = new TreeNode(rootValue);

        int pos = -1;
        //寻找根结点位置
        for (int i = iStart; i <= iEnd; i++) {
            if (in[i] == rootValue) {
                pos = i;
                break;
            } else if (i == iEnd) {
                System.out.println("null in loop");
                return null;
            }
        }
        int leftLength = pos - iStart;
        root.left = constructNode(pre, pStart + 1, pStart + leftLength, in, iStart, pos - 1);
        root.right = constructNode(pre, pStart + 1 + leftLength, pEnd, in, pos + 1, iEnd);
        return root;
    }
}


