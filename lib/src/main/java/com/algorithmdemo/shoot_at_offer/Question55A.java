package com.algorithmdemo.shoot_at_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入1棵二叉树的根节点，求该树的深度。
 */

public class Question55A {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println("node1深度：" + getDepth(node1));
        System.out.println("node3深度：" + getDepth(node3));
        System.out.println("node7深度：" + getDepth(node7));
        System.out.println("空输入：" + getDepth(null));
    }

    //通过递归的方式，求出每个子树的深度
    public static int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        leftDepth = getDepth(node.left);
        rightDepth = getDepth(node.right);
        //子树深度加上1就是当前树的深度
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        TreeNode cur;

        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                cur = queue.poll();
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            depth++;
        }

        return depth;
    }
}


