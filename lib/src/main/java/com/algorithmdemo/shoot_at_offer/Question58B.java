package com.algorithmdemo.shoot_at_offer;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个方法实现字符串的左旋转操作的功能。
 */

public class Question58B {
    public static void main(String[] args) throws Exception {
        String str1 = "abcdefg";
        System.out.println(str1 + " 左旋转为：" + leftRotate(str1,2));
    }

    private static String leftRotate(String inputString, int index){
        if (inputString == null || inputString.length() < 2 ){
            return inputString;
        }

        char[] inputChars = inputString.toCharArray();
        if (index > inputChars.length){
            index = inputChars.length;
        }

        reverse(inputChars,0,index - 1);
        reverse(inputChars,index,inputChars.length - 1);

        reverse(inputChars,0,inputChars.length - 1);

        return String.valueOf(inputChars);
    }

    private static char[] reverse(char[] chars, int start, int end){
        if (chars == null || chars.length < 2){
            return chars;
        }
        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return chars;
    }
}
