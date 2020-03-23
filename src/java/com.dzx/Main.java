package com.dzx;

public class Main {
    public static void main(String[] args) {
        MediumImageOverlap solution = new MediumImageOverlap();
        int[][] A = {{1,1,0},{0,1,0},{0,1,0}};
        int[][] B = {{0,0,0},{0,1,1},{0,0,1}};
        int result = solution.largestOverlap(A, B);
        System.out.println(result);
    }
}