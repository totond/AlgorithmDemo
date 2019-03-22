package com.algorithmdemo.shoot_at_offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请定义一个队列并实现函数max得到队列的最大值，要求函数getMax、pushBack、popFront的时间复杂度都是O(1)。
 */

public class Question59B {
    public static void main(String[] args) throws Exception {
        QueueWithMax queueWithMax1 = new QueueWithMax();
        queueWithMax1.pushBack(1);
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.pushBack(5);
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.pushBack(4);
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.pushBack(6);
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.pushBack(1);
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.pushBack(2);
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.popFront();
        queueWithMax1.popFront();
        queueWithMax1.popFront();
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.popFront();
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.popFront();
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
//        queueWithMax1.popFront();
//        System.out.println("全部出队后");
//        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
    }


}


/**
 * 一个单端队列，可以以O(1)的时间来执行getMax、pushBack、popFront方法。
 * 主要思路就是利用上一题的那种结构，把上一题那个滑动窗口看成这个队列，每次新增或者减少数据，都会更新最大值。
 */
class QueueWithMax{
    private int currentIndex = 0;
    //存放数据的队列，模拟上题的滑动窗口
    private Deque<InterData> dateDeque = new LinkedList<>();
    //存放有机会成为最大
    private Deque<InterData> maxDeque = new LinkedList<>();

    /**
     * 入队，将数字加到队尾
     * @param number 入队数字
     */
    public void pushBack(int number){
        //如果入队的数是大于等于队列队尾元素时，队尾元素出队，直到新的队尾元素代表的数值大于它或者队列为空，然后进队尾
        while (!maxDeque.isEmpty() && number >= maxDeque.peekLast().number){
            maxDeque.pollLast();
        }
        //入队操作
        InterData newData = new InterData(number,currentIndex);
        maxDeque.addLast(newData);
        dateDeque.addLast(newData);

        ++currentIndex;
    }

    /**
     * 出队，队头数字移出
     * @return 出队数字
     * @throws EmptyQueueException 队列是空的时候会抛出这个异常
     */
    public int popFront() throws EmptyQueueException {
        if (maxDeque.isEmpty()){
            throw new EmptyQueueException();
        }
        //如果出队的是最大元素，则maxDeque需要出队队头元素
        if (maxDeque.getFirst().index == dateDeque.getFirst().index){
            maxDeque.removeFirst();
        }

        return dateDeque.removeFirst().number;
    }

    /**
     * 获取队列里面元素的最大值
     * @return 最大值
     * @throws EmptyQueueException 队列是空的时候会抛出这个异常
     */
    public int getMax() throws EmptyQueueException {
        if (maxDeque.isEmpty()){
            throw new EmptyQueueException();
        }
        return maxDeque.peekFirst().number;
    }

    /**
     * 因为这是队列，不是数组，所以造一个有index的Data类出来
     */
    private class InterData{
        public InterData(int number, int index){
            this.number = number;
            this.index = index;
        }
        int number;
        int index;
    }

    private class EmptyQueueException extends Exception{
        public EmptyQueueException() {
            super("Queue is empty!");
        }
}


}
