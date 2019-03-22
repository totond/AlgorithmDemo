package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/29
 * desc   : 输入两个单链表，找出它们的第1个公共节点
 */

public class Question52 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int count1 = 1, count2 = 1;
        while (p1.next != null) {
            p1 = p1.next;
            count1++;
        }

        while (p2.next != null) {
            p2 = p2.next;
            count2++;
        }

        int n = 0;
        if (count1 > count2) {
            n = count1 - count2;
            while (n > 0) {
                n--;
                pHead1 = pHead1.next;
            }
            while (pHead1 != null) {
                if (pHead1.val == pHead2.val){
                    return pHead2;
                }
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return null;
        } else {
            n = count2 - count1;
            while (n > 0) {
                n--;
                pHead2 = pHead2.next;
            }
            while (pHead2 != null ) {
                if (pHead1.val == pHead2.val){
                    return pHead1;
                }
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return null;
        }
    }

    public static void main(String[] args){
        // 功能测试：二链表定义如下
        // 1->2->3->6->7
        //    4->5↗
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node4.next = node5;
//        node5.next = node7;
        node6.next = node7;

        ListNode commonNode = FindFirstCommonNode(node1,node1);
        System.out.println(commonNode.val);

        // 特殊输入测试：链表头节点 为空
        System.out.println(FindFirstCommonNode(null,null));
    }
}
