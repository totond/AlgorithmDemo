package com.algorithmdemo.shoot_at_offer;

import java.util.Stack;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/06
 * desc   : 用两个栈做一个队列
 */

public class Question9 {
    //入队栈
    Stack<Integer> stack1 = new Stack<Integer>();
    //出队栈
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    //出队时，如果出队栈为空，就注入它，给它出队
    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
