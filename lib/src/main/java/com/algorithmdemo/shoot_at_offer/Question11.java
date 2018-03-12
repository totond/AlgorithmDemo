package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/08
 * desc   : 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *          输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *          例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *          NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

public class Question11 {
    public static void main(String[] args) {
        int[] array = {3, 3, 3, 3, 4, 2};
        System.out.println(minNumberInRotateArray(array));
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int high = array.length - 1;
        int low = 0;
        int middle = high;
        //如果有前面的小于后面的，就说明最小数在low位置
        while (array[low] >= array[high]) {
            if (low + 1 >= high){
                middle = high;
                break;
            }
            middle = (high + low) / 2;

            if (array[middle] == array[low] && array[middle] == array[high]){
                //如果遇到三者相同的区间，则用暴力查找
                return minInOrder(array,low,high);
            }

            if (array[middle] >= array[low]) {
                //说明最小值在右半部分
                low = middle;
            } else if (array[middle] <= array[high]) {
                //说明最小值在左半部分
                high = middle;
            }
        }
        return array[middle];

    }

    //暴力寻找相邻两个数，前面比后面大的，就停下来
    private static int minInOrder(int[] array, int low, int high) {
        for (; low < high; low++) {
            int last = low - 1;
            if (last >= 0 && array[low] < array[last]) {
                break;
            }
        }
        return array[low];
    }
}
