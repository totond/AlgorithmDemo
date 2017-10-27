package com.algorithmdemo.shoot_at_offer;

/**
 * 给定一颗二叉搜索树，请找出其中第k大的结点。
 */

public class Question54 {
    private static int index = 0;

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(4);
        Node node6 = new Node(6);
        Node node7 = new Node(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println("第4大的数：" + findKth(node1,4));
        System.out.println("第1大的数：" + findKth(node1,1));
        System.out.println("第7大的数：" + findKth(node1,7));
        System.out.println("输入空：" + findKth(null,1));
        System.out.println("k不符合格式，如超出结点个数或者为0或负数：" + findKth(node1,0));
    }


    private static int findKth(Node root, int k){
        if (root == null){
            return -1;
        }
        index = k;
        Node target = findKthNode(root);
        if (target == null){
            return -1;
        }
        return target.value;
    }

    public static Node findKthNode(Node rootNode){
        Node target = null;

        if (rootNode.left != null) {
            target = findKthNode(rootNode.left);
        }
        System.out.println("index:" + index);
        if (target == null) {
            if (index == 1) {
                target = rootNode;
                System.out.println(target.value);
            }
            index--;
        }
        if (target == null && rootNode.right != null){
            target = findKthNode(rootNode.right);
        }

        return target;
    }


}

class Node{
    public int value;
    public Node left = null;
    public Node right = null;
    public Node(int value){
        this.value = value;
    }
}
