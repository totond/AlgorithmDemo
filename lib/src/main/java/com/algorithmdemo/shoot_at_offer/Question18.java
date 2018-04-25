package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/04/21
 * desc   : 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *          例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

public class Question18 {
    /**
     * 测试用例
     */
    public static void main(String[] args) {

        // 创建链表：1->2->3->4
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        // 功能测试：若删除的结点 = 链表中的结点 & 输出链表查看结果
        head = deleteDuplication(head);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }

        ListNode pre = null;
        ListNode cur = pHead;
        ListNode next = pHead.next;
        //是否需要删除操作
        boolean deleted = false;

        while (next != null) {
            //如果当前结点和下一个结点相等，就一直next
            while (next != null && cur.val == next.val) {
                deleted = true;
                next = next.next;
            }
            //如果之前有经历过next，deleted就会为true，则进行删除操作
            if (deleted) {
                //进行删除之余，还做为下一次的遍历做准备
                if (pre == null) {
                    cur = pHead = next;
                } else {
                    pre.next = cur = next;
                }
                if (next != null) {
                    next = next.next;
                }
                deleted = false;
            } else {
                pre = cur;
                cur = next;
                next = next.next;
            }
        }
        return pHead;
    }
}
