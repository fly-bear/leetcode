package com.dzx;

/**
 * 实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 此题坑特多，开头正负号可能不止一个，开头可能有一大串0，可能含有小数点，要时时防止空字符串
 */
public class MediumStringToInteger {
    public int myAtoi(String str) {
        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }
        int flag = 1;
        if (str.charAt(0) == '+' || str.charAt(0) == '-'){
            flag = str.charAt(0)=='-'?-1:1;
            str = str.substring(1);
        }
        if ("".equals(str)) {
            return 0;
        }
        if (str.charAt(0)<'0' || str.charAt(0)>'9'){
            return 0;
        }
        str = str.replaceAll("^0+", "").split("\\D")[0];
        if ("".equals(str)) {
            return 0;
        }
        if (str.length()>10) {
            return flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        if (str.length() != 10) {
            return Integer.parseInt(str) * flag;
        }else if (str.charAt(0)-'0'>2){
            return flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        int result = 0;
        int j=1;
        for (int i=str.length()-1; i>=0; i--) {
            if (flag==1 && Integer.MAX_VALUE -result < (str.charAt(i)-'0') * j) {
                return Integer.MAX_VALUE;
            }else if (flag == -1 && Integer.MIN_VALUE - result > (str.charAt(i) - '0') * j * flag){
                return Integer.MIN_VALUE;
            }
            result += (str.charAt(i) - '0') * j * flag;
            j *= 10;
        }
        return result;
    }
}
