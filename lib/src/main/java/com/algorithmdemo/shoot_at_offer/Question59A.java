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

    public static ArrayList<Integer> findMaxInWindows(int[] input, int size){
        if (input == null || size < 1 || input.length < size){
            return null;
        }
//        int[] results = new int[input.length - size + 1];
        ArrayList<Integer> results = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < size; i++){
            while (!deque.isEmpty() && input[i] >= input[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
        }

        for (int i = size; i < input.length; i++){
            results.add(input[deque.peekFirst()]);
            while (!deque.isEmpty() && input[i] >= input[deque.peekLast()]){
                deque.pollLast();
            }
            while (!deque.isEmpty() && deque.peekFirst() <= i - size){
                deque.pollFirst();
            }
            deque.addLast(i);
        }
        results.add(input[deque.peekFirst()]);
        return results;
    }

}
