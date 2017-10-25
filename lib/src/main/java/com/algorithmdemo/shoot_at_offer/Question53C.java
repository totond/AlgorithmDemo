package com.algorithmdemo.shoot_at_offer;

import com.algorithmdemo.IntArrayUtils;

/**
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 * 请实现一个函数，找出数组中任意一个数值等于其下标的元素。
 * 例如：{-3,-1,1,3,5}中，数字3和它的下标相等。
 */

public class Question53C {
    public static void main(String[] args) {
        int[] array1 = {-3, -1, 1, 3, 5};
        int[] array2 = {-1, 1, 3, 4, 5};
        int[] array3 = {0, 1, 5, 6, 8};
        int[] array4 = {0, 1, 2, 3, 4, 5};
        int[] array5 = {};
        int[] array6 = {-4, -3, -2, -1};
        int[] array7 = {-2, 7, 1, 6, 8, 4, 9};
        System.out.println(IntArrayUtils.intArrayToString(array1) + " 和下标相同的是：" + findIntSameASIndex(array1));
        System.out.println(IntArrayUtils.intArrayToString(array2) + " 和下标相同的是：" + findIntSameASIndex(array2));
        System.out.println(IntArrayUtils.intArrayToString(array3) + " 和下标相同的是：" + findIntSameASIndex(array3));
        System.out.println(IntArrayUtils.intArrayToString(array4) + " 和下标相同的是：" + findIntSameASIndex(array4));
        System.out.println(IntArrayUtils.intArrayToString(array5) + " 和下标相同的是：" + findIntSameASIndex(array5));
        System.out.println(IntArrayUtils.intArrayToString(array6) + " 和下标相同的是：" + findIntSameASIndex(array6));
        System.out.println(IntArrayUtils.intArrayToString(array7) + " 和下标相同的是：" + findIntSameASIndex(array7));
    }

    public static int findIntSameASIndex(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = (start + end) / 2;
        int midInt = array[mid];
        while (start <= end) {
            if (mid == midInt) {
                return midInt;
            } else if (mid < midInt) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
            midInt = array[mid];
        }

        return -1;

    }

}
