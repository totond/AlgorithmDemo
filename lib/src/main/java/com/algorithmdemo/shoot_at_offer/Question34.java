package com.algorithmdemo.shoot_at_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/26
 * desc   : 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *          路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */

public class Question34 {
    /**
     * 测试用例
     */
    public static void main(String[] args) {

        // 功能测试
        //            10
        //          /   \
        //         5     12
        //       /  \
        //      4    7
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        System.out.println(FindPath(root, 22));
        System.out.println(FindPath(root, 32));

        // 特殊输入测试
        FindPath(null, 12);
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //使用栈存取结点，实现先序遍历
        Stack<TreeNode> stack = new Stack<>();
        //cur表示当前遍历结点，last表示上一次的分叉结点
        TreeNode cur = root, last = null;
        //记录路径总值
        int sum = 0;
        //使用链表存储结点
        LinkedList<Integer> curPath = new LinkedList<>();
        while (cur != null || !stack.empty()) {
            //先遍历左结点
            while (cur != null) {
                curPath.add(cur.val);
                sum += cur.val;
                stack.push(cur);
                if (cur.left == null && cur.right == null && sum == target) {
                    //符合条件就输出
                    result.add(new ArrayList<Integer>(curPath));
                }
                cur = cur.left;
            }
            //遍历完左结点，取出上一结点
            if (!stack.empty()) {
                cur = stack.pop();
                //如果之前是有分叉转右的情况，则说明这个last结点已经是右子节点了，减去它的值
                if (last != null) {
                    sum -= last.val;
                    curPath.removeLast();
                }
                //记录上一个分叉结点
                last = cur;
                cur = cur.right;
            }
        }
        return result;
    }
}


