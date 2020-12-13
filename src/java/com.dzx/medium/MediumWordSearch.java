package com.dzx.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 深度优先搜索和回溯算法
 */
public class MediumWordSearch {
    public boolean exist(char[][] board, String word) {
        List<Integer> used = new ArrayList<>();
        char now = word.charAt(0);
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == now ) {
                    used.clear();
                    used.add(i*board[0].length + j);
                    if (word.length() == 1 || search(board, word, 1, i, j, -1, used))
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int target, int row, int col, int direct, List<Integer> used) {
        //上方
        if (direct != 0 && row > 0 && board[row-1][col] == word.charAt(target) && !used.contains((row-1)*board[0].length + col)) {
            List<Integer> temp = new ArrayList<>(used);
            temp.add((row-1)*board[0].length + col);
            if (target == word.length()-1 || search(board, word, target+1, row-1, col, 1, temp)) {
                used = temp;
                temp = null;
                return true;
            }
        }
        // 下方
        if (direct != 1 && row < board.length - 1 && board[row+1][col] == word.charAt(target) && !used.contains((row+1)*board[0].length + col)) {
            List<Integer> temp = new ArrayList<>(used);
            temp.add((row+1)*board[0].length + col);
            if (target == word.length()-1 || search(board, word, target+1, row+1, col, 0, temp)) {
                used = temp;
                temp = null;
                return true;
            }
        }
        // 左边
        if (direct != 2 && col > 0 && board[row][col-1] == word.charAt(target) && !used.contains((row)*board[0].length + col-1)) {
            List<Integer> temp = new ArrayList<>(used);
            temp.add((row)*board[0].length + col-1);
            if (target == word.length()-1 || search(board, word, target+1, row, col-1, 3, temp)) {
                used = temp;
                temp = null;
                return true;
            }
        }
        //右边
        if (direct != 3 && col < board[0].length - 1 && board[row][col+1] == word.charAt(target) && !used.contains((row)*board[0].length + col+1)) {
            List<Integer> temp = new ArrayList<>(used);
            temp.add((row)*board[0].length + col+1);
            if (target == word.length()-1 || search(board, word, target+1, row, col+1, 2, temp)) {
                used = temp;
                temp = null;
                return true;
            }
        }
        return false;
    }
}
