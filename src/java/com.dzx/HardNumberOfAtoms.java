package com.dzx;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 *
 *
 * 一个括号内用一个 map 储存，用栈储存每一层 map，遇到左括号入栈新 map，遇到右括号出栈最上层map，将里面的元素乘上后面的倍数存入上一层（栈顶）map
 */
public class HardNumberOfAtoms {
    public String countOfAtoms(String formula) {
       Stack<Map<String, Integer>> stack = new Stack<>();
       stack.push(new TreeMap<>());
       for (int i=0; i<formula.length(); i++) {
           if (formula.charAt(i) == '(') {
               stack.push(new TreeMap<>());
           }else if (formula.charAt(i) == ')') {
                Map<String, Integer> map = stack.pop();
                int left = i+1;
                while (i+1<formula.length() && Character.isDigit(formula.charAt(i+1))) {
                    i++;
                }
                int multiple=1;
                if (i>=left) {
                    multiple = Integer.parseInt(formula.substring(left, i+1));
                }
               int finalMultiple = multiple;
               map.forEach((x, y) -> stack.peek().put(x, stack.peek().getOrDefault(x, 0)+y* finalMultiple));
           }else {
               String atom;
                if (i+1<formula.length() && Character.isLowerCase(formula.charAt(i+1))) {
                    i++;
                    atom = formula.substring(i-1, i+1);
                }else {
                    atom = String.valueOf(formula.charAt(i));
                }
               int left = i+1;
               while (i+1<formula.length() && Character.isDigit(formula.charAt(i+1))) {
                   i++;
               }
               int multiple=1;
               if (i>=left) {
                   multiple = Integer.parseInt(formula.substring(left, i+1));
               }
               stack.peek().put(atom, stack.peek().getOrDefault(atom, 0)+ multiple);
           }
       }
       StringBuilder stringBuilder = new StringBuilder();
       stack.pop().forEach((x, y) -> {stringBuilder.append(x);if (y!=1){stringBuilder.append(y);}});
       return stringBuilder.toString();
    }
}
