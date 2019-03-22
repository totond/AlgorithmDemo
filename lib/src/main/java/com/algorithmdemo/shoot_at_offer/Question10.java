package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/11
 * desc   : 要求输入一个整数n，请你输出斐波那契数列的第n项。
 */

public class Question10 {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
    }


    public int Fibonacci_1(int n) {
        if (n < 0){
            return 0;
        }else if (n <= 1){
            return n;
        }
        return Fibonacci_1(n - 1) + Fibonacci_1(n - 2);
    }

    public int Fibonacci_2(int n) {
        if (n < 0){
            return 0;
        }else if (n <= 1){
            return n;
        }
        int sum = 0;
        int f1 = 1;
        int f2 = 0;
        for (int i = 1; i < n; i++) {
            sum = f1 + f2;
            f2 = f1;
            f1 = sum;
        }
        return sum;
    }

    //青蛙过河问题：
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int JumpFloor(int target) {
        if (target < 0){
            return 0;
        }else if (target <= 2){
            return target;
        }
        int sum = 0;
        int f1 = 1;
        int f2 = 2;
        for (int i = 2; i < target; i++){
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }

    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public static int JumpFloorII(int target) {
        if(target <= 0){
            return 0;
        }else if(target == 1){
            return 1;
        }else{
            int array[] = new int[target + 1];
            array[0] = 1;
            for(int i = 0; i <= target; i++){
                for(int j = 0; j < i; j++){
                    array[i] += array[j];
                }
            }
            return array[target];
        }
    }
}
