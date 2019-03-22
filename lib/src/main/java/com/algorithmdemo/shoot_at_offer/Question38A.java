package com.algorithmdemo.shoot_at_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/04/02
 * desc   : 输入1个字符串，按字典序 打印出该字符串中字符的所有排列
 */

public class Question38A {

    /**
     * 测试用例
     */
    public static void main(String[] args) {

        // 功能测试1：无重复字符 字符串
        System.out.println("功能测试1：无重复字符 字符串");
        System.out.println(Permutation("abc"));


        // 功能测试2：重复字符 字符串
        System.out.println("功能测试2：重复字符 字符串");
        System.out.println(Permutation("aac"));

        // 特殊输入测试：输入字符为空
        System.out.println("特殊输入测试：输入字符为空");
        System.out.println(Permutation(""));

    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null) {
            return result;
        }

        char[] chars = str.toCharArray();
        permutation(chars, result, 0);

        Collections.sort(result);
        return result;
    }

    private static void permutation(char[] chars, ArrayList<String> result, int index) {
        if (index < chars.length) {
            if (index == chars.length - 1) {
                result.add(String.valueOf(chars));
                return;
            } else {
                char cur = chars[index];
                for (int i = index; i < chars.length; i++) {
                    if (cur != chars[i] || i == index) {
                        swap(chars, index, i);
                        permutation(chars, result, index + 1);
                        swap(chars, index, i);
                    }
                }
            }
        }
    }

    private static void swap(char[] chars, int index1, int index2) {
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }
}
