package com.dzx.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给出两个图像 A 和 B ，A 和 B 为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。
 * 我们转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。之后，该转换的重叠是指两个图像都具有 1 的位置的数目。
 * （请注意，转换不包括向任何方向旋转。）
 * 最大可能的重叠是什么
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 *
 * 暴力枚举，A 中每一个1分别移动到 B 的每一个1，表示这种偏移方式下A这个点可以重合。统计每种偏移方式(x, y)次数，某种偏移方式的次数即为此种偏移的重合点个数
 */
public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        List<int[]> A1 = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i=0; i<A.length; i++) {
            for (int j=0; j<A[i].length; j++) {
                if (A[i][j] == 1) {
                    A1.add(new int[]{i,j});
                }
            }
        }
        A1.forEach(each -> {
            for (int i = -each[0]; i<=A.length-each[0]-1; i++) {
                for (int j = -each[1]; j<=A.length-each[1]-1; j++) {
                    if (B[each[0]+i][each[1]+j] == 1) {
                        if (count.containsKey(i*100 + j)) {
                            count.put(i*100+j, count.get(i*100 + j)+1);
                        }else {
                            count.put(i*100+j, 1);
                        }
                    }
                }
            }
        });
        return count.values().stream().max(Integer::compareTo).orElse(0);
    }
}
