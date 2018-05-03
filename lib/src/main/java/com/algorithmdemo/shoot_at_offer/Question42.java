package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/04/28
 * desc   : 输入一个整型数组，求它的所有连续子数组和中的最大值
 */

public class Question42 {
    public static void main(String[] args){

        // 功能测试：数组中无相同数字
        int[] array = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(array));

        // 特殊输入测试：数组为空
        int[] array2 = null;
        System.out.println(FindGreatestSumOfSubArray(array2));


    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array == null){
            return 0;
        }

        //存储之前一位连续子数组的和
        int sum = array[0];
        //存储和的最大值
        int maxSum = sum;

        for (int i = 1; i < array.length; i++){
            //如果前一位子数组和小于0，则说明下一位加上它，值会比当前小，所以直接把sum赋值给当前位置的值
            if (sum < 0){
                sum = array[i];
            }else {
                //否则就要加上当前值
                sum += array[i];
            }
            //判断是否取代最大值
            if (maxSum < sum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
