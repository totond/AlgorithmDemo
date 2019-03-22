package com.algorithmdemo.shoot_at_offer;

import java.util.Stack;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/23
 * desc   : 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 *          假设压入栈的所有数字均不相等。
 *          例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *          （注意：这两个序列的长度是相等的）
 */

public class Question31 {
    public static void main(String[] args) {
        // 压入序列
        int[] push = {1, 2, 3, 4, 5};

        // 判断弹出序列
        int[] pop1 = {3, 5, 4, 2, 1};
        int[] pop2 = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(push, pop1));
        System.out.println(IsPopOrder(push, pop2));
        // 特殊输入测试
        System.out.println(IsPopOrder(null, null));
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length == 0
                || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }
        //两个指针，一个指向push数组，一个指向pop数组
        int p1 = 0, p2 = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (p2 < popA.length) {

            //出栈队列的下一个值只可能是当前栈顶，或者未入栈的数
            //所以，如果栈空，或者栈顶元素不是出栈队列的元素，继续入栈，直到入完都没发现就说明没了
            if (stack.empty() || stack.peek() != popA[p2]) {
                if (p1 < pushA.length){
                    stack.push(pushA[p1]);
                    p1++;
                }else {
                    return false;
                }
            }else {
                stack.pop();
                p2++;
            }
        }
        //p2所有的数都匹配，那就说明是
        return true;
    }
}
