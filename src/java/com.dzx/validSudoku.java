package com.dzx;

public class validSudoku {
    public boolean isValidSudoku(char[][] board) {
        char row = 0b000000000;
        char[] cols = new char[9];
        char[] units = new char[9];
        for (int i=0; i<board.length; i++) {
            row = 0b000000000;
            for (int j=0; j<board[i].length; j++) {
//                if (i == 0) {
//                    cols[j] = 0b000000000;
//                }
//                if (i % 3 == 0) {
//                    units[i/3 + 3*(j/3)] = 0b000000000;
//                }
                if (board[i][j] == '.') {
                    continue;
                }
                int num = Integer.valueOf(String.valueOf(board[i][j]));
                if ((row & 1<<num) > 0) {
                    return false;
                }else {
                    row |= 1<<num;
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
