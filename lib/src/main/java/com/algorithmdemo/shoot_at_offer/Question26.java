package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/04/23
 * desc   : 输入2棵二叉树：A、B，请判断 B 是不是 A 的子结构。
 */

public class Question26 {
    public static void main(String[] args){
        // 树结构定义
        // 树A
        TreeNode root1 = new TreeNode (8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        // 树B
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        // 树C
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(3);

        // 功能测试：树B是树A的子结构、树C是树A的子结构
        System.out.println(HasSubtree(root1,root2));
//        System.out.println(HasSubtree(root1,root3));

        // 异常测试：树A、树B 任一为空 / 均为空时
//        System.out.println(HasSubtree(null,root3));
//        System.out.println(HasSubtree(root1,null));
//        System.out.println(HasSubtree(null,null));
    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        //如果当前结点相等，则进行递归判断其子结点
        if (root1.val == root2.val) {
            if (tree1HasTree2FromRoot(root1, root2)) {
                return true;
            }
        }

        //如果不相等，先遍历左子树，再遍历右子树
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public static boolean tree1HasTree2FromRoot(TreeNode root1, TreeNode root2) {
        //如果目标子树结点为空，说明这个方向递归结束，符合
        if (root2 == null) {
            return true;
        }
        //如果父树结点为空说明，这个方向没有相对应的结点的，不符合
        if (root1 == null) {
            return false;
        }

        //如果结点还是相等，继续递归左右子树对比
        if (root1.val == root2.val
                && tree1HasTree2FromRoot(root1.left, root2.left)
                && tree1HasTree2FromRoot(root1.right, root2.right)) {
            return true;
        }
        return false;
    }

}
