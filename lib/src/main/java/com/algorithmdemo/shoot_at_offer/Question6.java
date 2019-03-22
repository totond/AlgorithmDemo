package com.algorithmdemo.shoot_at_offer;

import java.util.ArrayList;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/06
 * desc   : 从尾到头打印链表
 */

public class Question6 {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode == null) {
            return list;
        }
        putNode(list, listNode);
        return list;
    }

    //利用递归，递归结束条件是node.next == null，到达链表尾部之后结束递归，实现反向输出
    private static void putNode(ArrayList<Integer> list, ListNode node) {
        if (node.next != null) {
            putNode(list, node.next);
        }
        list.add(node.val);
    }

    /**
     * 测试用例
     */
    public static void main(String[] args) {

        // 功能测试
        ListNode head = new ListNode(67);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(24);
        ListNode node4 = new ListNode(58);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(printListFromTailToHead((head)));
    }
}




