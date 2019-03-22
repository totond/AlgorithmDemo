package com.algorithmdemo.shoot_at_offer;

/**
 * 输入一个整数s，打印出所有和为s的连续正数序列
 */

public class Question57B {
    public static void main(String[] args) throws Exception {
        printNumbers(9);
        printNumbers(15);
        printNumbers(34);
        printNumbers(35);
        printNumbers(4);
    }

    public static void printNumbers(int sum) {
        System.out.println("和为" + sum + "的连续序列是：");
        if (!findContinuousSequence(sum)){
            System.out.println("找不到和为" + sum + "的连续序列");
        }
    }

    private static boolean findContinuousSequence(int sum) {
        int start = 1;
        int end = 2;
        //累加的数
        int curSum = start + end;
        int mid = (sum + 1) / 2;
        boolean found = false;
        //从1开始数，直到(sum + 1) / 2的数为止，因为超过了这个数的话，两个连续相加的数肯定会大于sum
        while (start < mid) {
            if (curSum == sum) {
                printContinuous(start, end);
                found = true;
            }
            //如果累加的数大于sum，而最小数还没到达界限，则最小数向前移动
            while (curSum > sum && start < mid) {
                curSum -= start;
                start++;
                if (curSum == sum) {
                    printContinuous(start, end);
                    found = true;
                }
            }
            end++;
            curSum += end;
        }
        return found;
    }

    /**
     * 用于输出连续数的方法
     * @param start 连续数的开始
     * @param end 连续数的终结
     */
    private static void printContinuous(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}
