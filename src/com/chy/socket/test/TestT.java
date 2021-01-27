package com.chy.socket.test;

import java.util.HashSet;
import java.util.Set;

public class TestT {
}

class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
    public static void main(String[] args) {
        int num[] = {2, 3, 1, 0, 2, 5, 3};
        Solution solution = new Solution();
        System.out.println(solution.findRepeatNumber(num));
    }
}

class Solution2 {
    public boolean findNumberIn2DArray(int[][] matrix, int target ) {
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
    }

}