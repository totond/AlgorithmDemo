package com.algorithmdemo.shoot_at_offer;

/**
 * 输入一颗二叉树的根结点，判断该树是不是平衡二叉树。
 */

public class Question55B {
    public static void main(String[] args) {
        BinaryTreeNodeWithDepth node1 = new BinaryTreeNodeWithDepth(5);
        BinaryTreeNodeWithDepth node2 = new BinaryTreeNodeWithDepth(3);
        BinaryTreeNodeWithDepth node3 = new BinaryTreeNodeWithDepth(7);
        BinaryTreeNodeWithDepth node4 = new BinaryTreeNodeWithDepth(2);
        BinaryTreeNodeWithDepth node5 = new BinaryTreeNodeWithDepth(4);
        BinaryTreeNodeWithDepth node6 = new BinaryTreeNodeWithDepth(6);
        BinaryTreeNodeWithDepth node7 = new BinaryTreeNodeWithDepth(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println("node1是否平衡二叉树：" + isBalancedBinaryTree(node1));
        System.out.println("空输入：" + isBalancedBinaryTree(null));

    }

    public static boolean isBalancedBinaryTree(BinaryTreeNodeWithDepth rootNode){
        if (rootNode == null){
            return false;
        }
        return isBalanced(rootNode);
    }

    public static boolean isBalanced(BinaryTreeNodeWithDepth pNode){
        if (pNode == null){
            return true;
        }

        if (isBalanced(pNode.left) && isBalanced(pNode.right)){
            int left = 0;
            int right =  0;
            if (pNode.left != null) {
                left = pNode.left.depth;
            }
            if (pNode.right != null){
                right = pNode.right.depth;
            }
            int diff = left - right;
            if (diff <= 1 && diff >= -1){
                pNode.depth = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }
}
