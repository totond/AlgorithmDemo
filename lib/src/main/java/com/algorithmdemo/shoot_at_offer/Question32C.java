package com.algorithmdemo.shoot_at_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/27
 * desc   :  之字形打印二叉树。即，第1层 从左到右打印，第二层 从右到左打印，第三层继续从左到右，以此类推。
 */

public class Question32C {


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null) {
            return result;
        }

        //因为栈是后进先出的原因，所以需要两个栈
        //一个栈负责存储当前的结点取出，一个栈负责下一层的结点加入，所以stack1负责偶数层，stack2负责奇数层
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        //用于表示深度
        int depth = 0;

        stack1.push(pRoot);

        while (!stack1.empty() || !stack2.empty()) {
            TreeNode node;
            if ((depth & 1) == 0) {
                //偶数层，遍历从右往左
                node = stack1.pop();
                list.add(node.val);
                //先入左结点
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
                if (stack1.empty()) {
                    //换层操作
                    depth++;
                    result.add(list);
                    list = new ArrayList<>();
                }
            } else {
                //奇数层，遍历从左往右
                node = stack2.pop();
                list.add(node.val);
                //先入右结点
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
                if (stack2.empty()) {
                    depth++;
                    result.add(list);
                    list = new ArrayList<>();
                }
            }

        }
        return result;
    }

}
