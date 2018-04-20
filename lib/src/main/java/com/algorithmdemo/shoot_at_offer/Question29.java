package com.algorithmdemo.shoot_at_offer;

import java.util.ArrayList;

/**
 * author : yany
 * e-mail : yanzhikai_yjk@qq.com
 * time   : 2018/03/24
 * desc   : 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */

public class Question29 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }
        //从外圈到里圈，分层处理，因为最里圈的坐标是行数和列数的一半，所以有这个限制条件
        for (int x = 0, y = 0; x * 2 < matrix.length && y * 2 < matrix[0].length; x++, y++) {
            printRowsAndColumns(matrix, x, y, result);
        }
        return result;
    }

    private void printRowsAndColumns(int[][] matrix, int x, int y, ArrayList<Integer> result) {
        int endX = matrix.length - 1 - x;
        int endY = matrix[0].length - 1 - y;

        //从左往右遍历
        for (int i = y; i <= endY; i++) {
            result.add(matrix[x][i]);
        }

        //从上往下，注意第一个已经被遍历了
        if (x < endX) {
            for (int i = x + 1; i <= endX; i++){
                result.add(matrix[i][endY]);
            }
        }

        //从右往左，注意第一个已经被遍历，还有y坐标是要递减
        if (x < endX && y < endY){
            for (int i = endY - 1; i >= y; i-- ){
                result.add(matrix[endX][i]);
            }
        }

        //从下往上，注意第一个和最后一个已经被遍历，x坐标要递减
        if (x < endX && y < endY){
            for (int i = endX - 1; i > x; i--){
                result.add(matrix[i][y]);
            }
        }
    }
}
