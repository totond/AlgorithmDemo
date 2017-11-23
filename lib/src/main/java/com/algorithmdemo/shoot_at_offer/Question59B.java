package com.algorithmdemo.shoot_at_offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请定义一个队列并实现函数max得到队列的最大值，要求函数getMax、pushBack、popFront的时间复杂度都是O(1)。
 */

public class Question59B {
    public static void main(String[] args) throws Exception {
        QueueWithMax queueWithMax1 = new QueueWithMax();
        queueWithMax1.pushBack(2);
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.pushBack(1);
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.pushBack(6);
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.pushBack(4);
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.pushBack(5);
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.pushBack(1);
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.popFront();
        queueWithMax1.popFront();
        queueWithMax1.popFront();
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.popFront();
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.popFront();
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
        queueWithMax1.popFront();
        System.out.println("全部出队后");
        System.out.println("queueWithMax1最大值：" + queueWithMax1.getMax());
    }


}



class QueueWithMax{
    private int currentIndex = 0;
    private Deque<InterData> dateDeque = new LinkedList<>();
    private Deque<InterData> maxDeque = new LinkedList<>();

    public void pushBack(int number){
        while (!maxDeque.isEmpty() && number >= maxDeque.peekLast().number){
            maxDeque.pollLast();
        }
        InterData newData = new InterData(number,currentIndex);
        maxDeque.addLast(newData);
        dateDeque.addLast(newData);

        ++currentIndex;
    }

    public int popFront() throws EmptyQueueException {
        if (maxDeque.isEmpty()){
            throw new EmptyQueueException();
        }
        if (maxDeque.getFirst().index == dateDeque.getFirst().index){
            maxDeque.removeFirst();
        }

        return dateDeque.removeFirst().number;
    }

    public int getMax() throws EmptyQueueException {
        if (maxDeque.isEmpty()){
            throw new EmptyQueueException();
        }
        return maxDeque.peekFirst().number;
    }

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
