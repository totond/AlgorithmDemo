package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/04/23
 * desc   :
 */

public class Question49 {

    /**
     * 测试用例
     */
    public static void main(String[] args){

        // 功能测试：2、3、4
        System.out.println(GetUglyNumber_Solution(7));


    }

    public static class UglyData{
        public int val = 0;
        public int index = 0;
        public boolean change = true;
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index < 1){
            return 0;
        }
        if (index < 7){
            return index;
        }

        int[] uglyNumbers = new int[index];

        int uglyNumber = 1;
        uglyNumbers[0] = uglyNumber;

        UglyData ugly2 = new UglyData();
        UglyData ugly3 = new UglyData();
        UglyData ugly5 = new UglyData();

        for (int i = 1; i < index; i++){
            UglyData result = findMinData(uglyNumbers,ugly2,ugly3,ugly5);
            result.change = true;
            if (uglyNumbers[i-1] != result.val) {
                uglyNumbers[i] = result.val;
            }else {
                i--;
            }

        }
        return uglyNumbers[index - 1];
    }

    private static UglyData findMinData(int[] uglyNumbers, UglyData uglyData2, UglyData uglyData3, UglyData uglyData5){
        if (uglyData2.change){
            uglyData2.val = uglyNumbers[uglyData2.index] * 2;
            uglyData2.index++;
            uglyData2.change = false;
        }
        if (uglyData3.change){
            uglyData3.val = uglyNumbers[uglyData3.index] * 3;
            uglyData3.index++;
            uglyData3.change = false;
        }
        if (uglyData5.change){
            uglyData5.val = uglyNumbers[uglyData5.index] * 5;
            uglyData5.index++;
            uglyData5.change = false;
        }

        UglyData temp = uglyData2.val < uglyData3.val ? uglyData2 : uglyData3;
        return temp.val < uglyData5.val ? temp : uglyData5;
    }
}
