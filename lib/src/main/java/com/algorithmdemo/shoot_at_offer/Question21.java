package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/12
 * desc   : 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *          使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 *          并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class Question21 {
    public static void main(String[] args){

        int[] array = {1,2,3,4,5,6,7};
        reOrderArray(array);
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i]);
        }
    }

    //运用归并的方法，分开奇数和偶数，然后转移数组的时候，奇数按顺序录入，偶数反序录入
    public static void reOrderArray(int [] array) {
        if (array == null){
            return;
        }
        int len = array.length;
        int[] temp = new int[len];
        int left = 0, right = len - 1;
        int n = 0;
        //分开奇数和偶数
        while (left <= right){
            if (isEven(array[n])){
                System.out.println("l:" + left + "r:" + array[n]);
                temp[left++] = array[n];
            }else {
                temp[right--] = array[n];
            }
            n++;
        }
        //录入
        for (int i = 0; i < len; i++){
            if (i < left) {
                array[i] = temp[i];
            }else {
                //反序录入
                array[i] = temp[len - 1 - i + left];
            }
        }

    }

    private static boolean isEven(int i){
        return (i & 0x1) == 1;
    }
}
