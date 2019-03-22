package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/04/25
 * desc   :
 */

public class Question61 {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }

        //用于装顺子牌数
        int[] continuous = new int[14];
        int min = 13, max = 0;
        for (int i : numbers) {
            //去除重复
            if (i != 0){
                if (continuous[i] == 0) {
                    continuous[i] = 1;
                }else {
                    return false;
                }
                //找出最小牌
                if (i < min){
                    min = i;
                }
                //找出最大牌
                if (i > max){
                    max = i;
                }
            }else {
                continuous[0]++;
            }
        }
        return max - min <= 4;
    }
}
