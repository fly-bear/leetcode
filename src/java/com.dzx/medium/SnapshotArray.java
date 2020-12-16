package com.dzx.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/16 21:30
 *
 * 实现支持下列接口的「快照数组」- SnapshotArray：
 *
 * SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
 * void set(index, val) - 会将指定索引 index 处的元素设置为 val。
 * int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
 * int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
 *
 *  一个列表， 每个元素为一个map， 保存每次更新的值， 用treeMap 的floorKey 可以获取不大于给定值的最大key，即最近更新版本
 **/
class SnapshotArray {
	List<TreeMap<Integer, Integer>> arr = new ArrayList<>();
	int snap = 0;
	public SnapshotArray(int length) {
		for (int i=0; i<length; i++)
			arr.add(new TreeMap<>());
	}

	public void set(int index, int val) {
		TreeMap<Integer, Integer> tm = arr.get(index);
		tm.put(snap, val);
	}

	public int snap() {
		return snap++;
	}

	public int get(int index, int snap_id) {
		TreeMap<Integer, Integer> tm = arr.get(index);
		Integer key = tm.floorKey(snap_id);
		return key == null ? 0 : tm.get(key);
	}
}

