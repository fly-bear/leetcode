package com.dzx.hard;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/16 22:20
 * 我们有n栋楼，编号从0到n - 1。每栋楼有若干员工。由于现在是换楼的季节，部分员工想要换一栋楼居住。
 * 给你一个数组 requests，其中requests[i] = [fromi, toi]，表示一个员工请求从编号为fromi的楼搬到编号为toi的楼。
 * 一开始所有楼都是满的，所以从请求列表中选出的若干个请求是可行的需要满足 每栋楼员工净变化为 0。
 * 意思是每栋楼 离开的员工数目 等于该楼 搬入的员工数数目。
 *
 * 比方说n = 3且两个员工要离开楼0，一个员工要离开楼1，一个员工要离开楼 2，
 * 如果该请求列表可行，应该要有两个员工搬入楼0，一个员工搬入楼1，一个员工搬入楼2。
 *
 * 请你从原请求列表中选出若干个请求，使得它们是一个可行的请求列表，并返回所有可行列表中最大请求数目。
 *
 *
 * 图论的题
 * 逐步剔除入度或出度为0的节点
 * 然后......暴力枚举， 剩下的请求长度为 m, 用0 ~ 1<<m 来枚举，二进制为 1 的位表示接受，为 0 表示拒绝
 **/
public class MaximumNumberOfAchievableTransferRequests {
	public int maximumRequests(int n, int[][] requests) {
		int count = 0;
		int[] in;
		int[] out;
		Set<Integer> reject = new HashSet<>();
		List<int[]> newReq = new ArrayList<>();
		for (int[] each : requests) {
			if (each[0] == each[1]) {
				++count;
			}else {
				newReq.add(each);
			}
		}
		requests = newReq.toArray(new int[0][]);
		boolean flag = true;
		while (flag) {
			flag = false;
			in = new int[n];
			out = new int[n];
			for (int[] each : requests) {
				if (reject.contains(each[0]) || reject.contains(each[1])) {
					continue;
				}
				++out[each[0]];
				++in[each[1]];
			}
			for (int i = 0; i < n; i++) {
				if (reject.contains(i)) {
					continue;
				}
				if (in[i] == 0) {
					reject.add(i);
					flag = true;
				}
				if (out[i] == 0) {
					reject.add(i);
					flag = true;
				}
			}
		}
		int[][] req = Arrays.stream(requests).filter(request -> !reject.contains(request[0]) && !reject.contains(request[1]))
			.toArray(int[][]::new);
		int max = 0;
		for (int i=0; i< 1<<req.length; i++) {
			in = new int[n];
			out = new int[n];
			for (int j=0;j<req.length;j++) {
				if ((i & 1<<j) == 0) {
					continue;
				}
				++out[req[j][0]];
				++in[req[j][1]];
			}
			for (int j=0;j<n;j++) {
				if (out[j] != in[j]) {
					break;
				}
				if (j==n-1) {
					int k = i;
					int accept = 0;
					while (k != 0) {
						k = (k-1) & k;
						accept++;
					}
					max = Math.max(max, accept);
				}
			}
		}
		return count + max;
	}
}
