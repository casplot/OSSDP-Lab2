import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
//测试原则：
//全面性：测试用例应该覆盖所有可能的输入情况，包括正常情况和异常情况。
//有效性：测试用例应该能够有效地发现软件中的错误和缺陷。
//可重复性：测试用例应该是可重复的，即在相同的环境和条件下，多次执行测试用例应该得到相同的结果。
//独立性：测试用例应该是相互独立的，一个测试用例的执行不应该影响其他测试用例的结果。
//简洁性：测试用例应该是简洁明了的，易于理解和执行。

//正常情况：包含0、1、2的数组，验证排序结果是否正确。
//边界情况：数组只包含0或只包含1或只包含2，验证方法是否能够正确处理。
//异常情况：数组为空或包含负数或包含大于2的数，验证方法是否能够正确处理。
public class L2022111034_13_Test {

    @Test
    public void testSortColors() {
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        int[] expected1 = {0, 0, 1, 1, 2, 2};
        sortColors(nums1);
        assertArrayEquals(expected1, nums1);

        int[] nums2 = {2, 0, 1};
        int[] expected2 = {0, 1, 2};
        sortColors(nums2);
        assertArrayEquals(expected2, nums2);

        int[] nums3 = {0};
        int[] expected3 = {0};
        sortColors(nums3);
        assertArrayEquals(expected3, nums3);

        int[] nums4 = {1, 1, 1};
        int[] expected4 = {1, 1, 1};
        sortColors(nums4);
        assertArrayEquals(expected4, nums4);

        int[] nums5 = {0, 0, 0, 1, 1, 1, 2, 2, 2};
        int[] expected5 = {0, 0, 0, 1, 1, 1, 2, 2, 2};
        sortColors(nums5);
        assertArrayEquals(expected5, nums5);
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        // 第一遍遍历，交换所有的 0 到前面
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
        // 第二遍遍历，交换所有的 1 到 ptr 位置之后
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
        // 2s 自然会排在最后
    }
}