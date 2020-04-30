package com.dzx;

/**
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 *
 * 动态规划,如果 A[i] 与 A[i-1] A[i-2]形成等差，则 A[i] 和整个等差子序列 A[k] ~ A[i-1] 成一新等差数列。
 * 因为最少 3 个一组，所以若前面最长连续等差子序列长 m，则加上 A[i]后可通过切分新增 m-1 个子序列
 * 每次递归,修改公共变量总序列数，然后返回末尾连续最长递增子序列长度，若无递增或递增中断，返回 2
 */
public class MediumArithmeticSlices {
	int sum = 0;
	public int numberOfArithmeticSlices(int[] A) {
		this.calculate(A, A.length-1);
		return sum;
	}

	private int calculate(int[] A, int end) {
		if (end <= 1) {
			return 2;
		}
		if (end == 2) {
			if (A[2] - A[1] == A[1] - A[0]) {
				sum += 1;
				return 3;
			}else {
				return 2;
			}
		}
		if (A[end] - A[end-1] == A[end-1] - A[end-2]) {
			int len = calculate(A, end-1);
			sum += len - 1;
			return len + 1;
		}else {
			calculate(A, end-1);
			return 2;
		}
	}
}
