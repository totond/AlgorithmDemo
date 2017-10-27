package com.algorithmdemo.shoot_at_offer;

/**
 * 二叉树的深度
 */

public class Question55A {
    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(8);
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

    public static int getDepth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        leftDepth = getDepth(node.left);
        rightDepth = getDepth(node.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
}


