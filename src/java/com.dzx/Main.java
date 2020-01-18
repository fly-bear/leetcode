package com.dzx;

public class Main {
    public static void main(String[] args) {
        MediumWordSearch solution = new MediumWordSearch();
        char[][] board = {
            {'a', 'b', 'c', 'e'},
            {'s', 'f', 'e', 's'},
            {'a', 'd', 'e', 'e'}};
        boolean result = solution.exist(board, "abceseeefs");
        System.out.println(result);
    }
}