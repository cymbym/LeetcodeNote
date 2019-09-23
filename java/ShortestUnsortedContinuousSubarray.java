/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.

1.
*/



class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flagInc = false;
        boolean flagDec = false;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] < nums[i - 1]) flagInc = true;
            if (flagInc && min > nums[i]) min = nums[i];
            if (nums[nums.length - i - 1] > nums[nums.length - i]) flagDec = true;
            if (flagDec && max < nums[nums.length - i - 1]) max = nums[nums.length - i - 1];
        }
        if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) return 0;
        else {
            int start = 0;
            int end = 0;
            flagInc = true;
            flagDec = true;
            for (int i = 0; i < nums.length; i ++) {
                if(flagInc && nums[i] > min) {
                    start = i;
                    flagInc = false;
                }
                if(flagDec && nums[nums.length - i - 1] < max) {
                    end = nums.length - i - 1;
                    flagDec = false;
                }
            }
            return end - start + 1;
        }
    }
}