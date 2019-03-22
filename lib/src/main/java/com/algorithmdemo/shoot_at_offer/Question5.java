package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/04
 * desc   : 请实现一个函数，将一个字符串中的空格替换成“%20”。
 *          例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

public class Question5 {
    public static void main(String[] args){
        System.out.println(replaceSpace(new StringBuffer("   ")));
    }
    public static String replaceSpace(StringBuffer str) {
        if (str == null){
            return null;
        }
        if (str.length() == 0){
            return "";
        }
        final String content = "%20";
        final String target = " ";
        String string = str.toString();
        String[] strings = string.split(target);
        StringBuilder sb;
        if (strings.length > 0) {
            sb = new StringBuilder(strings[0]);
        }else {
            sb  = new StringBuilder();
        }
        int i = 1;
        for (; i < strings.length; i++){
            sb.append(content);
            sb.append(strings[i]);
        }
        if (string.endsWith(target)){
            sb.append(content);
        }

        return sb.toString();
    }
}
