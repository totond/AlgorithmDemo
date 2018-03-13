package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/11
 * desc   : 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

public class Question15 {
    public int NumberOf1(int n) {
        //因为一个整数与比它小1的数进行或运算，它最靠近右边的1就会被消除掉
        int count = 0;
        while (n != 0){
            //循环消除整数里面的1，直到n为0，就可以算出有多少个1
            n = (n & n - 1);
            count++;
        }
        return count;
    }
}
