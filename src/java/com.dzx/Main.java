package com.dzx;

import com.dzx.easy.DegreeOfAnArray;
import com.dzx.hard.MaximumSumBstInBinaryTree;
import com.dzx.medium.CountNumberOfNiceSubarrays;
import com.dzx.medium.SnapshotArray;

public class Main {
    public static void main(String[] args) {
//	    DegreeOfAnArray solution = new DegreeOfAnArray();
//	    int result = solution.findShortestSubArray(new int[]{1,2,2,3,1});
	    SnapshotArray snapshotArray = new SnapshotArray(1);
	    snapshotArray.set(0,15);
	    snapshotArray.snap();
	    snapshotArray.snap();
	    snapshotArray.snap();
	    snapshotArray.get(0,2);
	    snapshotArray.snap();
	    snapshotArray.snap();
	    snapshotArray.get(0,0);
        System.out.println("pass");
    }
}