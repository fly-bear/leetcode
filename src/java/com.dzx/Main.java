package com.dzx;

public class Main {
    public static void main(String[] args) {
        validSudoku validSudoku = new validSudoku();
        char[][] board = {
                {'8','3','.','.','7','.','.','.','.'},
  {'6','.','.','1','9','5','.','.','.'},
  {'.','9','8','.','.','.','.','6','.'},
  {'8','.','.','.','6','.','.','.','3'},
  {'4','.','.','8','.','3','.','.','1'},
  {'7','.','.','.','2','.','.','.','6'},
  {'.','6','.','.','.','.','2','8','.'},
  {'.','.','.','4','1','9','.','.','5'},
  {'.','.','.','.','8','.','.','7','9'}
        };
        boolean result = validSudoku.isValidSudoku(board);
        System.out.println(result);
    }
}