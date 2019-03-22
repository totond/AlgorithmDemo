package com.algorithmdemo.shoot_at_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/19
 * desc   : 输入n个整数，找出其中最小的K个数。
 */

public class Question40 {
    public static void main(String[] args){

        int[] data = {7,4,1,2,6,5,3,8,9};
        System.out.println(GetLeastNumbers_Solution_1(data,4).toString());

        // 特殊输入测试：数组为空
        int[] data2 = null;
        System.out.println(GetLeastNumbers_Solution_1(data2,4));

    }

    //快排分区解法:利用快排分区，找到最小的k个数区域，把他们全放到前面。
    //时间、空间效率最高，但是会破坏数据的原始顺序。
    //大数据的时候可以先找出一半内存允许的最小区域，然后不断合并其他的一半最小，直到合成到最后才找最后k个，还可以每次使用一半区域最后的那个数作为key
    public static ArrayList<Integer> GetLeastNumbers_Solution_0(int [] input, int k) {
        if(input == null || input.length == 0 || k <= 0 || k > input.length) {
            System.out.println("输入的数据不合法");
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0, end = input.length - 1;
        int key = partition(input,start,end);
        while (key != k - 1){
            if (key > k - 1 ){
                end = key - 1;
            }else {
                start = key + 1;
            }
            key = partition(input,start,end);
            System.out.println("key" + key);
        }
        for (k--; k >= 0; k--){
            result.add(input[k]);
        }
        return result;
    }

    private static int partition(int[] array, int low, int high) {
        int temp = array[low];
        while (low < high){
            while (low < high && array[high] >= temp){
                high--;
            }
            if (low < high) {
                array[low++] = array[high];
            }
            while (low < high && array[low] <= temp){
                low++;
            }
            if (low < high){
                array[high--] = array[low];
            }
        }
        array[low] = temp;
        return low;
    }

    //容器解法：用一个容器，把最小的k个数装起来，然后把数放进去，不断替换里面的数，直到最后。
    //容器使用平衡二叉树或者红黑树，所以这里使用TreeSet，然而限制就是不能识别相同的数。
    //时间效率不够前者高，但是不会破坏原本数据，只占用k个数据的空间。
    public static ArrayList<Integer> GetLeastNumbers_Solution_1(int [] input, int k) {
        if(input == null || input.length == 0 || k <= 0 || k > input.length) {
            System.out.println("输入的数据不合法");
            return new ArrayList<>(Arrays.asList(new Integer[]{1,2,3}));
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i : input){

            if (set.size() < k){
               set.add(i);
            }else {
                if (i < set.last()){
                    set.pollLast();
                    set.add(i);
                }
            }
        }
        return new ArrayList<Integer>(set);
    }
}
