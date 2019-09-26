/*
We define a harmounious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:

Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 

Note: The length of the input array will not exceed 20,000.


1.我的解法：先排序。后得到：
  nums: 1  2  2  2  3  3  5  7            -14  -13  1  1  1  1  3  4
  cnt1: 1  1  2  3  1  2  1  1             1    1   1  2  3  4  1  1
  cnt2: 0  1  1  1  3  3  0  0             0    1   0  0  0  0  0  0
  max : 1  2  3  4  4  5  5  5             1    2   2  2  2  2  2  2   
*/
class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int cnt_1 = 1;
        int cnt_2 = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i + 1] - nums[i] == 0) {
                cnt_1 ++;                                                // 左2  2
                res = cnt_2 == 0 ? res : Math.max(res, cnt_1 + cnt_2);   // 右1  1  1  1 : 左2  2  2
            }
            else if (nums[i + 1] - nums[i] == 1) {
                cnt_2 = cnt_1;
                cnt_1 = 1;
                res = Math.max(res, cnt_1 + cnt_2);                      // 左1  2   
            } else {
                cnt_1 = 1;                                               // 左5
                cnt_2 = 0;
            }
        }
        return cnt_2 == 0 ? res : Math.max(res, cnt_1 + cnt_2);
    }
}
