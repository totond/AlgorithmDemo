package com.algorithmdemo;

/**
 * Created by yany on 2017/10/25.
 */

public class IntArrayUtils {
    public static String intArrayToString(int[] array){
        if (array == null || array.length == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        sb.append(String.valueOf(array[0]));
        for (int i = 1; i < array.length; i++){
            sb.append(",");
            sb.append(array[i]);
        }
        sb.append("}");
        return sb.toString();
    }
}
