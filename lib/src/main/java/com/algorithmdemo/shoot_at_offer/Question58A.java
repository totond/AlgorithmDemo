package com.algorithmdemo.shoot_at_offer;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字幕一样处理。
 */

public class Question58A {
    public static void main(String[] args) throws Exception {
        String str1 = "you are a student!";
        System.out.println(str1 + " 翻转为：" + reverseSentence(str1));
        String str2 = "I love you!";
        System.out.println(str2 + " 翻转为：" + reverseSentence(str2));
        String str3 = "ha ";
        System.out.println(str3 + " 翻转为：" + reverseSentence(str3));
        String str4 = " ";
        System.out.println(str4 + " 翻转为：" + reverseSentence(str4));
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

    public static String reverseSentence(String inputString){
        if (inputString == null || inputString.length() < 2){
            return inputString;
        }

        char[] inputChars = inputString.toCharArray();

        reverse(inputChars,0,inputChars.length - 1);

        int start = 0;
        int end = 1;
        while (end < inputChars.length){
            if (inputChars[end] == ' '){
                reverse(inputChars,start,end - 1);
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
