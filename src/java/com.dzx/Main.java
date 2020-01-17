package com.dzx;

public class Main {
    public static void main(String[] args) {
        MediumRevealCardsInIncreasingOrder solution = new MediumRevealCardsInIncreasingOrder();
        int[] deck = {17,13,11,2,3,5,7};
        int[] result = solution.deckRevealedIncreasing(deck);
        System.out.println(result);
    }
}