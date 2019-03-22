package com.algorithmdemo.shoot_at_offer;

import java.util.Collections;
import java.util.TreeSet;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/31
 * desc   : 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *          如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */

public class Question41 {
    public static void main(String[] args){

        // 测试用例
        // 功能测试
        System.out.println("功能测试");
        Question41 test = new Question41();
        // 通过循环插入，代表动态从数据流获取数据
        for(int i = 0; i < 10; ++i) {
            test.Insert(i);
            System.out.println(test.GetMedian() + "  ");
            System.out.println("----");
        }
        System.out.println();

        // 特殊输入测试：无数据输入
        System.out.println("特殊输入测试");
        Question41 test1 = new Question41();
        System.out.print(test1.GetMedian() + "  ");

    }


    //最小堆，最大的在Last
    TreeSet<Integer> smallSet = new TreeSet<>();
    //最大堆，最小的在Last
    TreeSet<Integer> bigSet = new TreeSet<>(Collections.<Integer>reverseOrder());

    public void Insert(Integer num) {

        if (((smallSet.size() + bigSet.size()) & 1) == 0){
            //如果目前数量是偶数数，则把新来的数加入到最大堆，最大堆里面最小的拿出来，加入最小堆
            bigSet.add(num);
            smallSet.add(bigSet.pollLast());
        }else {
            //如果目前数量是偶数数，则把新来的数加入到最小堆，最小堆里面最大的拿出来，加入最大堆
            smallSet.add(num);
            bigSet.add(smallSet.pollLast());
        }

    }

    public Double GetMedian() {
        if (smallSet.isEmpty() && bigSet.isEmpty()){
            return 0d;
        }
        if (((smallSet.size() + bigSet.size()) & 1) == 0){
            //如果是偶数，则把最小堆最大的，和最大堆最小的两个数拿出来，返回平均值
            return (((double) smallSet.last() + bigSet.last()) / 2);
        }else {
            //如果是偶数，则返回最小堆最大的数
            return Double.valueOf(smallSet.last());
        }
    }
}
