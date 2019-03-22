package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/04/23
 * desc   : 操作给定的二叉树，将其变换为源二叉树的镜像。
 */

public class Question27 {
    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.left);
        Mirror(root.right);
    }
}
