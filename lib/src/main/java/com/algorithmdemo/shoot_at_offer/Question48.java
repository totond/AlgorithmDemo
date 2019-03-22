package com.algorithmdemo.shoot_at_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/10
 * desc   :
 */

public class Question48 {
    /**
     * 解题思路3：优化使用滑动窗口
     */
    public static String  lengthOfLongestSubstring(String s) {

        if (s == null){
            return null;
        }
        if (s.length() == 0){
            return s;
        }

        int n = s.length(), ans = 0;
        String str = s;

        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            if (ans < j - i + 1){
                str = s.substring(i,j + 1);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return str;
    }

    /**
     * 测试用例
     */
    public static void main(String[] args){

        // 功能测试
        System.out.println(lengthOfLongestSubstring("arabcacfr"));

    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        if(matrix == null || str == null || matrix.length == 0 || str.length == 0)
            return false;

        int flag[] = new int[matrix.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    private static boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {

        int index = i * cols + j;

        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;

        if(k == str.length - 1)
            return true;

        flag[index] = 1;
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }

        flag[index] = 0;
        return false;
    }



    public static int movingCount(int threshold, int rows, int cols) {
        int flag[][] = new int[rows][cols];
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private static int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1) return 0;
        flag[i][j] = 1;
        return (1+helper(i - 1, j, rows, cols, flag, threshold)
                + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + helper(i, j + 1, rows, cols, flag, threshold)
        );
    }

    public  static int numSum(int number){
        int sum=0;
        while (number>0){
            sum += number%10;
            number/=10;
        }
        return sum;
    }
}
