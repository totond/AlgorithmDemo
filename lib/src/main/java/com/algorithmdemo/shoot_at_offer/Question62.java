package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/04/29
 * desc   :
 */

public class Question62 {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1){
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++){
            last = (last + m) % i;
        }

        return last;
    }
}
