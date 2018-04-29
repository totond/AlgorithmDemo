package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/04/20
 * desc   : 一个链表中包含环，请找出该链表的环的入口结点。
 */

public class Question23 {
    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        pHead.next = null;
        System.out.println(EntryNodeOfLoop(pHead));
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode p1 = pHead, p2 = pHead;
        int loopLength = 0;
        //计算环的长度
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            loopLength++;
            if (p1 == p2) {
                break;
            }
        }

        //如果不成环，则返回空
        if (p2 == null || p2.next == null) {
            return null;
        }

        p1 = p2 = pHead;
        //让p2先走环的长度步数
        while (loopLength > 0) {
            p2 = p2.next;
            loopLength--;
        }

        //到了相遇地点，就是环的入口
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
