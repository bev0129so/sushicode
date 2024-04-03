package com.pg.programmercarl.arr;

/**
 * @author luojx
 * @date 2024/3/2 9:58
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = spiralMatrix.spiralMatrix(3);
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + " ");
            }
            System.out.println();
        }
    }
    
    /*
        1  2  3  4
        12 13 14 5
        11 16 15 6
        10 9  8  7
     */

    public int[][] spiralMatrix(int n) {
        int[][] result = new int[n][n];
        int row = 0, col = 0;
        int circleTime = n / 2;
        int blank = 1;
        int x = 0, y = 0;
        int cnt = 1;
        while ((circleTime--) > 0) {
//            上边
            int i = x, j = y;
            for (j = y; j < n - blank; j++) {
                result[i][j] = cnt++;
            }
//            右边
            for (i = x; i < n-blank; i++) {
                result[i][j] = cnt++;
            }
//            下边
            for (; j > y; j--) {
                result[i][j] = cnt++;
            }
//            左边
            for (; i > x ; i--) {
                result[i][j] = cnt++;
            }
            x++;
            y++;
            blank++;
        }
        if (n % 2 == 1) {
            result[n/2][n/2] = cnt;
        }
        return result;
    }
}
