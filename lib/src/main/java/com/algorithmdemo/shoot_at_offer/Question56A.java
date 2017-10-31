package com.algorithmdemo.shoot_at_offer;

import com.algorithmdemo.IntArrayUtils;

/**
 * 一个整型数组里除了两个数字之外，其他数字都出现了两次。请写程序找出这两个值出现一次的数字。
 * 要求时间复杂度O(n)，空间复杂度O(1)。
 * ps:这种解法有个问题，不能分辨出输入的数组符不符合上面的规则。
 */

public class Question56A {
    public static void main(String[] args){
        int[] array1 = {1, 2, 2, 5, 5, 4, 7, 4};
        System.out.println("数组：" +IntArrayUtils.intArrayToString(array1));
        findTwoOnceNumber(array1);

        int[] array2 = {-1, -3, -1, 3, 5, 2, 2, 3};
        System.out.println("数组：" +IntArrayUtils.intArrayToString(array2));
        findTwoOnceNumber(array2);

        int[] array3 = {1, 2, 2, 1, 3, 3, 1};
        System.out.println("数组：" +IntArrayUtils.intArrayToString(array3));
        findTwoOnceNumber(array3);

        int[] array4 = {1};
        System.out.println("数组：" +IntArrayUtils.intArrayToString(array4));
        findTwoOnceNumber(array4);
    }

    public static void findTwoOnceNumber(int[] intArray){
        if (intArray == null || intArray.length < 2){
            System.out.println("数组为空或者长度不足");
            return;
        }
        int orResult = 0;
        for (int i : intArray){
            orResult ^= i;
        }
        int indexOf1 = findFirstBitIs1(orResult);
        int number1 = 0, number2 = 0;
        for (int i : intArray){
            if (isBit1(i,indexOf1)){
                number1 ^= i;
            }else {
                number2 ^= i;
            }
        }
        System.out.println("只出现一次的数字是：" + number1 + "和" + number2);
    }

    private static int findFirstBitIs1(int i){
        int index = 0;
        while (((i & 1) == 0) && index < 32){
            i = i >> 1;
            index++;
        }
        return index;
    }

    private static boolean isBit1(int number, int index){
        number = number >> index;
        return (number & 1) == 1;
    }

}
