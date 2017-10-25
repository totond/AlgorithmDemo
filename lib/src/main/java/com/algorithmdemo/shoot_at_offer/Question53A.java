package com.algorithmdemo.shoot_at_offer;

/**
 * 统计一个数字在排序数组中出现的次数。例如，输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组出现了4次，所以输出4。
 *
 */
public class Question53A {

    public static void main(String[] args){
        int[] array = {-1,-1,0,2,3,3,4,5,5,6,7,7,7,8,9};
        System.out.println("搜索2的次数：" + getRepeatNumberTimes(array,2));
        System.out.println("搜索-1的次数：" + getRepeatNumberTimes(array,-1));
        System.out.println("搜索7的次数：" + getRepeatNumberTimes(array,7));
        System.out.println("搜索9的次数：" + getRepeatNumberTimes(array,9));
        System.out.println("搜索10的次数：" + getRepeatNumberTimes(array,10));
        System.out.println("搜索-5的次数：" + getRepeatNumberTimes(array,10));
    }

    /**
     * 寻找一个排序数组里面数的出现次数
     * @param inputArray
     * @param number
     * @return
     */
    public static int getRepeatNumberTimes(int[] inputArray, int number){
        if (inputArray == null || inputArray.length == 0){
            return 0;
        }
        int numberIndex = findNumber(inputArray,0,inputArray.length-1,number);
//        System.out.println("index " + numberIndex);
        if (numberIndex == -1){
            return -1;
        }else {
            int start = findRepeatStart(inputArray,number,numberIndex);
            int end = findRepeatEnd(inputArray,number,numberIndex);
            return end - start + 1;
        }
    }

    private static int findRepeatStart(int[] inputArray,int number,int index){
        int start = index;
        while (start > 0){
            if (inputArray[start - 1] != number){
                return start;
            }
            start--;
        }
        return start;
    }

    private static int findRepeatEnd(int[] inputArray,int number,int index){
        int end = index;
        while (end < inputArray.length - 1){
            if (inputArray[end + 1] != number){
                return end;
            }
            end++;
        }
        return end;
    }

    private static int findNumber(int[] inputArray, int start, int end, int number){
        if (start > end){
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midInt = inputArray[midIndex];
        if (midInt == number){
            return midIndex;
        }else if (midInt > number){
            return findNumber(inputArray,start,midIndex - 1,number);
        }else {
            return findNumber(inputArray,midIndex + 1,end,number);
        }
    }



}
