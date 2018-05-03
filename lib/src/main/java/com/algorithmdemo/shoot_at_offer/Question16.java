package com.algorithmdemo.shoot_at_offer;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/11
 * desc   : 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *          要注意考虑0的几次方是多少，非0数的0次方。还有负数的非0次方要乘以倒数。
 */

public class Question16 {
    public static void main(String[] args) {

        // 测试用例
        System.out.println(Power(2, 4));
        System.out.println(Power(2, -4));
        System.out.println(Power(2, 0));
        System.out.println(Power(-2, 3));
        System.out.println(Power(0, 0));
        System.out.println(Power(0, 3));
        System.out.println(Power(0, -1));
    }

    public static double Power(double base, int exponent) {
        if (exponent == 0){
            return 1;
        }

        if (base == 0){
            //0的负数次方无意义，取输出0，正数次方也是0，0的0次方已经在上面判断了。
            return 0;
        }
        double result = base;
        //负数的话因子取反，次数改回正
        if (exponent < 0){
            result = 1 / result;
            exponent = -exponent;
        }

        return powerWithUnsignedExponent(result,exponent);

    }

    //处理非0正数的exponent次方
    public static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        //递归处理次方数的一半的结果，然后结果再平方，直到exponent = 0 或者 1，才停止，这样可以明显降低相乘次数
        double result = powerWithUnsignedExponent(base, exponent >> 1);

        result *= result;
        //如果幂次数是奇数，则需要再乘以一次底数
        if ((exponent & 0x1) == 1){
            result = result * base;
        }
        return result;

    }
}
