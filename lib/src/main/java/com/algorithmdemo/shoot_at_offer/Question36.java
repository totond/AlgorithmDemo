package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/04/30
 * desc   :
 */

public class Question36 {
    public static void main(String[] args) {
        // 功能测试
        //            10
        //          /   \
        //         6     14
        //        / \    / \
        //       4   8  12 16
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        printList(Convert(root));
    }

    /**
     * 与解题算法无关，仅用于测试时打印链表
     */
    private static void printList(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
    }

    private static TreeNode pre, head;

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        inConvert(pRootOfTree);
        return head;
    }

    private static void inConvert(TreeNode node) {
        if (node == null) {
            return;
        }
        inConvert(node.left);

        if (pre == null) {
            pre = node;
            head = node;
        } else {
//            if (pre.right == null){
            pre.right = node;
//            }
//            if (node.left == null){
            node.left = pre;
//            }

            pre = node;
        }


        inConvert(node.right);
    }
}
