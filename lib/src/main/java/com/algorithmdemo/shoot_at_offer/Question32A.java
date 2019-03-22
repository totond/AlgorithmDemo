package com.algorithmdemo.shoot_at_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/23
 * desc   : 不分行、从上 -> 下、左 -> 右 打印二叉树的每个节点，也就是层序遍历
 */

public class Question32A {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return result;
    }

}
