/*
We define a harmounious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:

Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 

Note: The length of the input array will not exceed 20,000.
*/

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for
    }
}

class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int cnt_1 = 1;
        int cnt_2 = 1;
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i + 1] - nums[i] == 0) cnt_1 ++;
            else if (nums[i + 1] - nums[i] == 1) {
                cnt_2 = cnt_1;
				cnt_1 = 1;
            } else {
                res = Math.max(res, cnt_1 + cnt_2);
                cnt_1 = 1;
                cnt_2 = 1;
            }
        }
        return Math.max(res, cnt_1 + cnt_2);
    }
}