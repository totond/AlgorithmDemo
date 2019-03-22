package com.algorithmdemo.shoot_at_offer;

import com.algorithmdemo.IntArrayUtils;

/**
 * 一个长度为n-1的递增排序数组中所有数字都是唯一的，并且每个数字都在0~n-1的范围内。
 * 在这个范围内的n个数字中有且只有一个数字不在该数组，请找出这个数字
 */

public class Question53B {

    public static void main(String[] args) {
        int[] array1 = {0,1,3,4,5};
        int[] array2 = {0,1,2,3,4,5,6,8,9,10,11};
        int[] array3 = {0,1,2,4,5,6,7,8};
        int[] array4 = {1,2,3,4,5,6};
        int[] array5 = {1,2,4,6,7,8};
        int[] array6 = {};
        int[] array7 = {3,4,6,1,2,5};
        System.out.println(IntArrayUtils.intArrayToString(array1) + "缺的是：" + findUniqueInt(array1));
        System.out.println(IntArrayUtils.intArrayToString(array2) + "缺的是：" + findUniqueInt(array2));
        System.out.println(IntArrayUtils.intArrayToString(array3) + "缺的是：" + findUniqueInt(array3));
        System.out.println(IntArrayUtils.intArrayToString(array4) + "缺的是：" + findUniqueInt(array4));
        System.out.println(IntArrayUtils.intArrayToString(array5) + "缺的是：" + findUniqueInt(array5));
        System.out.println(IntArrayUtils.intArrayToString(array6) + "缺的是：" + findUniqueInt(array6));
        System.out.println(IntArrayUtils.intArrayToString(array7) + "缺的是：" + findUniqueInt(array7));

    }

    public static int findUniqueInt(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        return findDifferent(array,0,array.length - 1);
    }

    private static int findDifferent(int[] array, int start, int end) {
        int mid = (start + end) / 2;

        if (mid == array[mid]) {
            int newStart = mid + 1;
            if (newStart <= end) {
                return findDifferent(array, newStart, end);
            } else {
                return newStart;
            }
        } else if (mid < array[mid]) {
            int newEnd = mid - 1;
            if (newEnd >= 0) {
                return findDifferent(array, start, newEnd);
            }else {
                return newEnd;
            }
        }else {
            return -1;
        }
    }


}
