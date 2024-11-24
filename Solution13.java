/*
 * @Description:
 * 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 */

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        // 第一遍遍历，交换所有的0到前面
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
        // 第二遍遍历，交换所有的1到ptr位置之后
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
        // 2s自然会排在最后
    }
}

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 定义测试用例
        int[][] testCases = {
                {2, 0, 2, 1, 1, 0},
                {0, 0, 1, 1, 2, 2},
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {0},
                {1},
                {2},
                {},
                {1, 0, 2, 1, 0, 2, 1, 0}
        };

        // 定义预期结果
        int[][] expectedResults = {
                {0, 0, 1, 1, 2, 2},
                {0, 0, 1, 1, 2, 2},
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {0},
                {1},
                {2},
                {},
                {0, 0, 0, 1, 1, 1, 2, 2}
        };

        // 运行测试
        boolean allPassed = true;
        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int[] expected = expectedResults[i];
            // 复制数组以避免修改原始测试用例
            int[] nums = Arrays.copyOf(testCase, testCase.length);
            solution.sortColors(nums);
            boolean passed = arraysEqual(nums, expected);
            if (passed) {
                System.out.println("Test Case " + (i + 1) + " Passed.");
            } else {
                System.out.println("Test Case " + (i + 1) + " Failed.");
                System.out.println("Input: " + Arrays.toString(testCase));
                System.out.println("Expected: " + Arrays.toString(expected));
                System.out.println("Got: " + Arrays.toString(nums));
                allPassed = false;
            }
        }

        if (allPassed) {
            System.out.println("All test cases passed!");
        } else {
            System.out.println("Some test cases failed. Please check the details above.");
        }
    }

    // 辅助方法：比较两个数组是否相同
    private static boolean arraysEqual(int[] a, int[] b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.length != b.length) return false;
        for(int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}