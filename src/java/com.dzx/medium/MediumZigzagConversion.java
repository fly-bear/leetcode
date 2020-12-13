package com.dzx.medium;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *  Z 字形变换
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 实现这个将字符串进行指定行数变换的函数：
 *
 * 一次遍历，字符装入对应行的 stringBuilder
 */
public class MediumZigzagConversion {
    public String convert(String s, int numRows) {
        if (s.equals("") || s.length()<=numRows) {
            return s;
        }
        StringBuilder[] lists = new StringBuilder[numRows];
        int row = 0;
        int derect = 1;
        for (char c : s.toCharArray()) {
            if (lists[row] == null) {
                lists[row] = new StringBuilder();
            }
            lists[row].append(c);
            if (row == numRows-1 && row == 0){
                continue;
            }else if (row == numRows-1) {
                derect = -1;
            }else if (row == 0) {
                derect = 1;
            }
            row += derect;
        }
        return Arrays.stream(lists).parallel().map(Objects::toString).collect(Collectors.joining());
    }
}
