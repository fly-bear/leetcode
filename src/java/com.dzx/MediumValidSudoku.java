package com.dzx;

/*
    有效数独,将行,列,宫格的情况以 10 位二进制数存储,每次与运算判断某数字是否用过
 */
public class MediumValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        char row = 0b000000000;
        char[] cols = new char[9]; // 每一列
        char[] units = new char[9]; // 每一个宫格
        for (int i=0; i<board.length; i++) {
            row = 0b000000000;
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = Integer.valueOf(String.valueOf(board[i][j]));
                if ((row & 1<<num) > 0) { // 与运算判断对应位是否为 1
                    return false;
                }else {
                    row |= 1<<num; // 若没重复,将对应位置 1
                }
                if ((cols[j] & 1<<num) > 0) {
                    return false;
                }else {
                    cols[j] |= 1<<num;
                }
                if ((units[i/3 + 3*(j/3)] & 1<<num) > 0) {
                    return false;
                }else {
                    units[i/3 + 3*(j/3)] |= 1<<num;
                }
            }
        }
        return true;
    }
}
