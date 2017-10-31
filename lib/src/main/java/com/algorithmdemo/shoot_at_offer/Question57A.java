package com.algorithmdemo.shoot_at_offer;

import com.algorithmdemo.IntArrayUtils;

/**
 * 输入一个递增数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 */

public class Question57A {
    public static void main(String[] args) throws Exception {
        int[] array1 = {1, 2, 4, 7, 11, 15};
        System.out.println("数组1：" + IntArrayUtils.intArrayToString(array1));
        printNumbers(array1, 15);
        printNumbers(array1, 18);
        printNumbers(array1, 30);
        int[] array2 = {-3, -2, 1, 5, 8, 11};
        System.out.println("数组2：" + IntArrayUtils.intArrayToString(array2));
        printNumbers(array2,-2);
        int[] array3 = null;
        System.out.println("数组3：" + IntArrayUtils.intArrayToString(array3));
        printNumbers(array3, 3);
    }

    private static boolean findTwoNumberWithSum(int[] intArray, int sum){
        if (intArray == null || intArray.length < 2){
            return false;
        }

        int start = 0;
        int end = intArray.length - 1;

        while (start < end){
            int curSum = intArray[start] + intArray[end];
            if (curSum == sum){
                System.out.println("和为" + sum + "的两个数字是" + intArray[start] + "和" + intArray[end]);
                return true;
            } else if (curSum < sum) {
                start++;
            }else {
                end--;
            }
        }
        return false;
    }

    public static void printNumbers(int[] intArray, int sum){
        if (!findTwoNumberWithSum(intArray, sum)){
            System.out.println("找不到和为" + sum + "的两个数字");
        }
    }
}
