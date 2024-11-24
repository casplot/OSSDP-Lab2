public class Solution {
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
