package com.algorithmdemo.shoot_at_offer;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字幕一样处理。
 */

public class Question58A {
    public static void main(String[] args) throws Exception {
        String str1 = "I don't know that you are a student!";
        System.out.println(str1 + " 翻转为：" + reverseSentence(str1));
        String str2 = "I love you!";
        System.out.println(str2 + " 翻转为：" + reverseSentence(str2));
        String str3 = "ha ";
        System.out.println(str3 + " 翻转为：" + reverseSentence(str3));
        String str4 = " ";
        System.out.println(str4 + " 翻转为：" + reverseSentence(str4));
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

    /**
     * 翻转字符串
     * @param inputString 输入的字符串
     * @return 翻转结果字符串
     */
    public static String reverseSentence(String inputString){
        //边界处理
        if (inputString == null || inputString.length() < 2){
            return inputString;
        }

        char[] inputChars = inputString.toCharArray();

        //所有字符翻转一遍
        reverse(inputChars,0,inputChars.length - 1);

        int start = 0;
        int end = 1;

        //遇到空格则把前面的单词翻转
        while (end < inputChars.length){
            if (inputChars[end] == ' '){
                reverse(inputChars,start,end - 1);
                //如果下一个还没到达终点，就把start提到空格后
                if (end + 1 < inputChars.length){
                    start = end + 1;
                }
            }
            end++;
        }
        reverse(inputChars,start,end - 1);

        return String.valueOf(inputChars);


    }

}
