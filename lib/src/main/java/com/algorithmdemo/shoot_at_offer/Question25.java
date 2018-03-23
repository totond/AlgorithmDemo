package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/14
 * desc   : 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

public class Question25 {
    //利用归并排序那种合并思想，合并两个有序序列
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null ){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode head = null;
        if (list1.val < list2.val){
            head = new ListNode(list1.val);
            list1 = list1.next;
        }else {
            head = new ListNode(list2.val);
            list2 = list2.next;
        }

        //建立一个新的链表，这样不用破坏原链表
        ListNode cur = head;

        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            }else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;

        }

        while (list1 != null){
            cur.next = new ListNode(list1.val);
            list1 = list1.next;
            cur = cur.next;
        }

        while (list2 != null){
            cur.next = new ListNode(list2.val);
            list2 = list2.next;
            cur = cur.next;
        }
        return head;
    }

    //还有一种递归解法，更简洁，但是效率低一点,以后实现
}
