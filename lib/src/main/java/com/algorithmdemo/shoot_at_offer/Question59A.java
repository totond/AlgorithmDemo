package com.algorithmdemo.shoot_at_offer;

import com.algorithmdemo.ArrayUtils;
import com.algorithmdemo.IntArrayUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口的最大值。
 */

public class Question59A {
    public static void main(String[] args) throws Exception {
        int[] array1 = {2, 3, 4, 2, 6, 2, 5, 1};
        int size1 = 3;
        System.out.println("数组" + IntArrayUtils.intArrayToString(array1) + "的大小为" + size1 + "的滑动窗口最大值为：");
        ArrayUtils.printList(findMaxInWindows(array1,size1));

        int[] array2 = {2, 3, 4, 2, 6, 2, 5, 1, 7};
        int size2 = 4;
        System.out.println("数组" + IntArrayUtils.intArrayToString(array2) + "的大小为" + size2 + "的滑动窗口最大值为：");
        ArrayUtils.printList(findMaxInWindows(array2,size2));

        int[] array3 = {2, 6, 4, 2, 6, 1, 5, 1, 8, 3, 2, 5};
        int size3 = 2;
        System.out.println("数组" + IntArrayUtils.intArrayToString(array3) + "的大小为" + size3 + "的滑动窗口最大值为：");
        ArrayUtils.printList(findMaxInWindows(array3,size3));
    }

    //使用一个双端队列来保存index，队头放最大，队尾放较小，入队时先把比入队元素小的从队尾顶出去，再入队
    //每次滑动后判断队头元素是否已经不再滑动窗口，是的话需要移除，让后面的顶上，再继续判断是否在
    public static ArrayList<Integer> findMaxInWindows(int[] input, int size){
        if (input == null || size < 1 || input.length < size){
            return null;
        }

        //也可以使用数组来装结果
//        int[] results = new int[input.length - size + 1];
        ArrayList<Integer> results = new ArrayList<>();
        //创建一个双端队列，队头是用来装大的元素，队尾是装小的，从大到小排队
        Deque<Integer> deque = new LinkedList<>();

        //当滑动窗口还没完全滑进数组时的处理
        for (int i = 0; i < size; i++){
            //当遇到的数是大于队列里面的数时，队尾元素出队，直到队尾元素代表的数值比它大或者队列为空，然后进队尾
            while (!deque.isEmpty() && input[i] >= input[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
        }

        for (int i = size; i < input.length; i++){
            //把队头元素做为结果
            results.add(input[deque.peekFirst()]);
            //如果遇到的数是大于等于队列队尾元素时，队尾元素出队，直到新的队尾元素代表的数值大于它或者队列为空，然后进队尾
            while (!deque.isEmpty() && input[i] >= input[deque.peekLast()]){
                deque.pollLast();
            }
            //如果队头元素的index已经不处在滑动窗口，则出队，然后代表第二大的元素成为了队头，如果还不在，则继续出队，直到在为止
            while (!deque.isEmpty() && deque.peekFirst() <= i - size){
                deque.pollFirst();
            }
            //经过前面的处理，当前元素已经可以进入处理过的队列了
            deque.addLast(i);
        }
        //把最后的滑动窗口元素队头元素输出为结果
        results.add(input[deque.peekFirst()]);
        return results;
    }

}
