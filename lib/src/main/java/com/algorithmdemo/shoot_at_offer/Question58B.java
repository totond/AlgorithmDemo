package com.algorithmdemo.shoot_at_offer;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个方法实现字符串的左旋转操作的功能。
 */

public class Question58B {
    public static void main(String[] args) throws Exception {
        String str1 = "abcdefg";
        System.out.println(str1 + " 左旋转为：" + leftRotate(str1,2));
        String str2 = "123456789";
        System.out.println(str2 + " 左旋转为：" + leftRotate(str2,4));
    }

    /**
     * 左旋转一个字符串
     * @param inputString 输入的字符串
     * @param index 左旋转位置
     * @return 左旋转结果
     */
    private static String leftRotate(String inputString, int index){
        if (inputString == null || inputString.length() < 2 ){
            return inputString;
        }

        char[] inputChars = inputString.toCharArray();
        if (index > inputChars.length){
            index = inputChars.length;
        }

        //根据index把字符串分成两部分，这两部分都翻转一遍，然后再整个字符串全部翻转
        reverse(inputChars,0,index - 1);
        reverse(inputChars,index,inputChars.length - 1);

        reverse(inputChars,0,inputChars.length - 1);

        return String.valueOf(inputChars);
    }

    /**
     * 翻转一个字符数组的部分或全部
     * @param chars 输入的字符数组
     * @param start 翻转开始的index
     * @param end 翻转结束的index
     * @return 翻转结果
     */
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
