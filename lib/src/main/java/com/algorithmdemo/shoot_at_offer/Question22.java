package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/12
 * desc   : 输入一个链表，输出该链表中倒数第k个结点。
 */

public class Question22 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //定义左右两个指针，右指针先走k步，然后左右一起走，当右指针走到尽头的时候，左指针就指向倒数k个结点
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null){
            return null;
        }
        ListNode left = head, right = head;
        while (right != null && k > 0){
            right = right.next;
            k--;
        }
        //如果少于k个结点
        if (k > 0){
            return null;
        }
        while (right != null){
            right = right.next;
            left = left.next;
        }

        return left;
    }

}
