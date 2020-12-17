package com.dzx.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4]的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 构建最大堆和最小堆，平均分配数字， 树高之差超过 1 时， 取高树的堆顶数据放到低树堆中， 两边执行调整，
 *
 */
public class MedianFinder {
	List<Integer> maxHeap;
	List<Integer> minHeap;
	public MedianFinder() {
		maxHeap = new ArrayList<>();
		minHeap = new ArrayList<>();
	}

	public void addNum(int num) {
		if (maxHeap.isEmpty() && minHeap.isEmpty()){
			maxHeap.add(num);
		}else if (minHeap.isEmpty()) {
			if (num < maxHeap.get(0)) {
				maxHeap.add(num);
				adjustUp(maxHeap, true, maxHeap.size()-1);
			}else {
				minHeap.add(num);
				adjustUp(minHeap, false, minHeap.size()-1);
			}
		}else {
			if (num > minHeap.get(0)) {
				minHeap.add(num);
				adjustUp(minHeap, false, minHeap.size()-1);
			}else {
				maxHeap.add(num);
				adjustUp(maxHeap, true, maxHeap.size()-1);
			}
		}
		while (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
			if (maxHeap.size() > minHeap.size()) {
				minHeap.add(maxHeap.get(0));
				adjustUp(minHeap, false, minHeap.size()-1);
				maxHeap.set(0, maxHeap.get(maxHeap.size()-1));
				maxHeap.remove(maxHeap.size()-1);
				adjustDown(maxHeap, true, 0);
			}else {
				maxHeap.add(minHeap.get(0));
				adjustUp(maxHeap, true, maxHeap.size()-1);
				minHeap.set(0, minHeap.get(minHeap.size()-1));
				minHeap.remove(minHeap.size()-1);
				adjustDown(minHeap, false, 0);
			}
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return maxHeap.isEmpty()?0:(maxHeap.get(0) + minHeap.get(0))/2.0;
		}else if (maxHeap.size()>minHeap.size()) {
			return maxHeap.get(0);
		}else {
			return minHeap.get(0);
		}
	}

	private void adjustUp(List<Integer> heap, boolean isMaxHeap, int target) {
		if (heap.size() <= 1 || target <= 0) {
			return;
		}
		int father = (target-2)%2 == 0?(target-2)/2:(target-1)/2;
		if (heap.get(father) > heap.get(target) ^ isMaxHeap) {
			int temp = heap.get(father);
			heap.set(father, heap.get(target));
			heap.set(target, temp);
			target = father;
			adjustUp(heap, isMaxHeap, target);
		}
	}

	private void adjustDown(List<Integer> heap, boolean isMaxHeap, int target) {
		if (heap.size() <= 1 || 2*target+1>=heap.size()) {
			return;
		}
		if (heap.get(target) > heap.get(target*2+1) ^ isMaxHeap) {
			int temp = heap.get(target*2+1);
			heap.set(target*2+1, heap.get(target));
			heap.set(target, temp);
			adjustDown(heap, isMaxHeap, target*2+1);
		}
		if (2*target+2 < heap.size() && (heap.get(target) > heap.get(target*2+2) ^ isMaxHeap)) {
			int temp = heap.get(target*2+2);
			heap.set(target*2+2, heap.get(target));
			heap.set(target, temp);
			adjustDown(heap, isMaxHeap, target*2+2);
		}
	}
}
