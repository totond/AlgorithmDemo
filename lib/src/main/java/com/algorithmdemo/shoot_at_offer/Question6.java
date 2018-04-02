package com.algorithmdemo.shoot_at_offer;

import java.util.ArrayList;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/06
 * desc   : 从尾到头打印链表
 */

public class Question6 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode == null) {
            return list;
        }
        putNode(list, listNode);
        return list;
    }

    //利用递归，递归结束条件是node.next == null，到达链表尾部之后结束递归，实现反向输出
    private void putNode(ArrayList<Integer> list, ListNode node) {
        if (node.next != null) {
            putNode(list, node.next);
        }
        list.add(node.val);
    }
}




