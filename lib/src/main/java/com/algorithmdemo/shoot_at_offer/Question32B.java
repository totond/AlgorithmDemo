package com.algorithmdemo.shoot_at_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/27
 * desc   :  按层分行、从上 -> 下、左 -> 右 打印二叉树的每个节点
 */

public class Question32B {

    //关键在于分层，这里用curCount和nextCount记录当前层的结点数和下一层的结点数，当curCount等于0的时候，就相当于换层
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null){
            return result;
        }

        int curCount = 1, nextCount = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            curCount--;
            if (node.left != null){
                queue.offer(node.left);
                nextCount++;
            }
            if (node.right != null){
                queue.offer(node.right);
                nextCount++;
            }
            if (curCount == 0){
                //换层操作
                curCount = nextCount;
                nextCount = 0;
                result.add(list);
                list = new ArrayList<>();
            }
        }
        return result;
    }
}
