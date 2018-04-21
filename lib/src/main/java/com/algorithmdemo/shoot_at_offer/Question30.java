package com.algorithmdemo.shoot_at_offer;

import java.util.Stack;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/16
 * desc   : 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */

public class Question30 {

    public class StackWithMin {
        //存放数据的栈
        private Stack<Integer> dataStack = new Stack<>();
        //存放最小值的栈，入栈的时候把入栈元素和栈顶对比，如果比它小则直接入栈，不是则入栈一个栈顶元素
        private Stack<Integer> minStack = new Stack<>();

        public void push(int node) {
            dataStack.push(node);
            if (minStack.empty()) {
                minStack.push(node);
            } else {
                int min = minStack.peek();
                if (min > node) {
                    minStack.push(node);
                }else {
                    minStack.push(min);
                }
            }
        }

        public void pop() {
            minStack.pop();
            dataStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
