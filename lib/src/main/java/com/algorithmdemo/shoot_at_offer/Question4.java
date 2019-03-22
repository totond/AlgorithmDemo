package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/04
 * desc   : 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *          请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class Question4 {

    //先从右上角的数开始判断，
    //如果目标数小于当前数，则说明这一列没有目标数（都比它大），当前数往左移
    //如果目标数大于当前数，则说明这一行没有目标数（都比它小），当前数往下移
    //如果等于，则说明找到，
    //如果已经移出边界，则说明没有。
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
