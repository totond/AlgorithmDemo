package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/04/30
 * desc   : 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 */

public class Question33 {
    /**
     * 测试用例
     */
    public static void main(String[] args){

        // 功能测试
        int[] data = {1,2,3,4,5};
        int[] data1 = {7,4,6,5};
        System.out.println(VerifySquenceOfBST(data));
        System.out.println(VerifySquenceOfBST(data1));

        // 特殊输入测试
        System.out.println(VerifySquenceOfBST(null));
    }

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence,0,sequence.length - 1);
    }

    private static boolean verify(int[] sequence, int start, int end) {
        //如果是后序遍历序列，那么最后一个数肯定是树的根结点
        int root = sequence[end];
        if (end <= start){
            return true;
        }

        boolean bigger = false;
        int divider = end;

        //比根结点小的和大的，划分为两个区间，继续递归判断
        //找出分界点
        for (int i = start;i < end; i++){
            if (bigger){
                if (root >= sequence[i]){
                    return false;
                }
            }else {
                if (root <= sequence[i]){
                    divider = i;
                    bigger = true;
                }
            }
        }
        boolean result = true;
        //如果分界点为0，说明左边已经没有结点区间，不用递归
        if (divider != 0) {
            result &= verify(sequence, start, divider - 1);
        }
        //递归右边结点区间
        result &= verify(sequence,divider,end - 1);
        return result;
    }
}
