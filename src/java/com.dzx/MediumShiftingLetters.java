package com.dzx;

/**
 *一个由小写字母组成的字符串 S，和一个整数数组 shifts。
 * 将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。
 * 例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。
 * 对于每个 shifts[i] = x ， 将 S 中的前 i+1 个字母移位 x 次。
 * 返回将所有这些移位都应用到 S 后最终得到的字符串。
 *
 * 计算每一个字符最终移位位数即可，可使用取余计算
 */
public class MediumShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder stringBuilder = new StringBuilder();
        int sum = 0;
        for(int i=shifts.length-1; i>=0; i--) {
            sum = sum + shifts[i]>=26?sum+shifts[i]%26:sum+shifts[i];
            stringBuilder.insert(0, (char)((S.charAt(i) + sum -'a')%26 + 'a'));
        }
        return stringBuilder.toString();
    }
}
