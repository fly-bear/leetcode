package com.dzx;

public class Main {
    public static void main(String[] args) {
        MediumStringToInteger solution = new MediumStringToInteger();
        int result = solution.myAtoi("-6147483648");
        System.out.println(result);
    }
}