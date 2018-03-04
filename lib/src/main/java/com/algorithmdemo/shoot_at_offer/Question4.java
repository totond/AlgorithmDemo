package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/04
 * desc   :
 */

public class Question4 {

    public boolean Find(int target, int [][] array) {
        if (array == null){
            return false;
        }
        if(array.length > 0 && array[0].length > 0){
            int r = 0;
            int c = array[0].length - 1;
            while (r < array.length && c >= 0){
                int current = array[r][c];
                if (current == target){
                    return true;
                }else if (current > target){
                    c--;
                }else {
                    r++;
                }
            }
        }
        return false;
    }
}
