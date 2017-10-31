package com.algorithmdemo.shoot_at_offer;

import com.algorithmdemo.IntArrayUtils;

/**
 * 在一个数组中除了一个数字只出现一次之外，其他数字都出现三次，请找出那个只出现一次的数字。
 */

public class Question56B {
    public static void main(String[] args) throws Exception {
        int[] array1 = {2, 2, 5, 5, 4, 7, 4, 2, 4, 5};
        System.out.println("数组" + IntArrayUtils.intArrayToString(array1)
                + "中唯一出现一次数字是：" + findOnceNumber(array1));

        int[] array2 = {5, 5, -3, 5, -4, -2, -2, -4, -2, -4};
        System.out.println("数组" + IntArrayUtils.intArrayToString(array2)
                + "中唯一出现一次数字是：" + findOnceNumber(array2));

        int[] array3 = {1, 0, 1, 1};
        System.out.println("数组" + IntArrayUtils.intArrayToString(array3)
                + "中唯一出现一次数字是：" + findOnceNumber(array3));

        int[] array4 = {-2};
        System.out.println("数组" + IntArrayUtils.intArrayToString(array4)
                + "中唯一出现一次数字是：" + findOnceNumber(array4));

//        int[] array5 = {};
//        System.out.println("数组" + IntArrayUtils.intArrayToString(array5)
//                + "中唯一出现一次数字是：" + findOnceNumber(array5));

    }

    public static int findOnceNumber(int[] intArray) throws Exception {
        if (intArray == null || intArray.length < 1) {
            throw new Exception("数组为空或者长度不足");
        }

        int[] bitSum = new int[32];

        for (int i : intArray) {
            int bitMask = 1;
            for (int j = 31; j >= 0; --j){
                int bit = i & bitMask;
                if (bit != 0){
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++){
            result = result << 1;
            result += bitSum[i] % 3;
        }

        return result;
    }
}
