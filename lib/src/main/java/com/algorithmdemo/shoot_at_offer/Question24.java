package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/14
 * desc   : 翻转链表
 */

public class Question24 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //定义3个prev,cur,next指针，cur一开始指向head，next指向下一个，循环条件next != null，最后返回cur
    public static ListNode ReverseList_1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode n = head.next;
        if (n == null) {
            return head;
        }
        ListNode c = head;
        ListNode p = null;
        while (n != null) {
            //翻转cur结点
            c.next = p;
            //继续去下一个结点
            p = c;
            c = n;
            n = n.next;
        }
        //翻转最后一个结点
        c.next = p;
        return c;
    }

    //定义3个prev,cur,next指针，cur一开始指向head，next不指向，循环条件cur != null，最后返回pre
    public static ListNode ReverseList_2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode n = null;
        ListNode c = head;
        ListNode p = null;
        while (c != null) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }

    public static void main(String[] args) {
        // 功能测试：输入链表有多个节点
        // 链表 = 1->2->3->4->5->6
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode result  = ReverseList_1(head);
        System.out.println(result.val);
        System.out.println(result.next.val);

        // 异常情况测试1：输入链表有1个节点
        // 链表 = 1
        ListNode head2 = new ListNode(1);
        ReverseList_1(head2);

        // 异常情况测试2：输入链表为空
        ListNode head3 = null;
        ReverseList_1(head3);

    }
}
