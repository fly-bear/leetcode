package com.dzx;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * 请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * 返回从 S 拆分出来的所有斐波那契式的序列块，如果不能拆分则返回 []。
 *
 * 回溯 + 剪枝，及时除去数字大于 2147483647 的路径。前两个数字决定了后面的数列，所以对前两个回溯就行。对后面的数字循环判断是否满足斐波那契。
 */
public class MediumSplitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> fib = new ArrayList<>();
        for (int index1 = 1; index1<S.length()-1;index1++) {
            if (index1>10 ||(S.charAt(0) == '0' && index1>1)) {
                break;
            }
            for (int index2 = index1+1; index2<S.length();index2++) {
                if (S.charAt(index1) == '0' && index2-index1>1) {
                    break;
                }
                fib.clear();
                int length2 = 0;
                long num1 = Long.parseLong(S.substring(0, index1));
                long num2 = Long.parseLong(S.substring(index1, index2));
                if (num1>Integer.MAX_VALUE || num2>Integer.MAX_VALUE) {
                    break;
                }
                fib.add((int) num1);
                fib.add((int) num2);
                while (this.valid(fib, S, index2+length2)) {
                    length2 += fib.get(fib.size()-1).toString().length();
                    if (index2+length2 >= S.length()) {
                        return fib; // 成功
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    private boolean valid(List<Integer> fib, String s, int index) {
        int length = 1;
        long num=0;
        while (index+length <= s.length() && num <= Integer.MAX_VALUE) {
            num = Long.parseLong(s.substring(index, index+length));
            if (num == fib.get(fib.size()-1)+fib.get(fib.size()-2)) {
                fib.add((int)num);
                return true;
            } else if (num > fib.get(fib.size()-1)+fib.get(fib.size()-2)) {
                break;
            }
            length++;
        }
        return false;
    }
}
