package com.algorithmdemo.shoot_at_offer;

import java.util.Stack;

/**
 * 给定一颗二叉搜索树，请找出其中第k大的结点。
 */

public class Question54 {
    private static int index = 0;

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

        System.out.println("第4大的数：" + findKth(node1, 4));
        System.out.println("第1大的数：" + findKth(node1, 1));
        System.out.println("第7大的数：" + findKth(node1, 7));
        System.out.println("输入空：" + findKth(null, 1));
        System.out.println("k不符合格式，如超出结点个数或者为0或负数：" + findKth(node1, 0));
    }


    private static int findKth(BinaryTreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        index = k;
        BinaryTreeNode target = findKthNode(root);
        if (target == null) {
            return -1;
        }
        return target.value;
    }

    //二叉搜索树的中序遍历就是从小到大遍历，所以只需要中序遍历到第k个结点
    private static BinaryTreeNode findKthNode(BinaryTreeNode rootNode) {
        BinaryTreeNode target = null;

        if (rootNode.left != null) {
            target = findKthNode(rootNode.left);
        }
        if (target == null) {
            if (index == 1) {
                target = rootNode;
                System.out.println(target.value);
            }
            index--;
        }
        if (target == null && rootNode.right != null) {
            target = findKthNode(rootNode.right);
        }

        return target;
    }


    //牛客版本
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }

        TreeNode cur = pRoot;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.empty()){
                cur = stack.pop();
                k--;
                if (k == 0){
                    return cur;
                }else {
                    cur = cur.right;
                }
            }
        }
        return null;
    }
}

