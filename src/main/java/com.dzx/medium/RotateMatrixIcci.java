package com.dzx.medium;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
 *
 * 从外向内一圈圈处理， 元素三次交换完成旋转，位运算实现交换
 */
public class RotateMatrixIcci {
    public void rotate(int[][] matrix) {
        for (int circle=0; circle<matrix.length/2; circle++) {
            for (int column = circle; column<matrix.length-1-circle; column++) {
                this.exchange(matrix, circle, column, column, matrix.length-1-circle);
                this.exchange(matrix, circle, column,matrix.length-1-circle, matrix.length-1-column);
                this.exchange(matrix, circle, column, matrix.length-1-column,circle);
            }
        }
    }

    private void exchange(int[][] matrix, int x1, int y1, int x2, int y2) {
        matrix[x1][y1] ^= matrix[x2][y2];
        matrix[x2][y2] ^= matrix[x1][y1];
        matrix[x1][y1] ^= matrix[x2][y2];
    }
}
