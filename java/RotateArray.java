/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?

1.方法一：如题目中Explanation所示，执行k轮，每轮将最后一个数置换到首位。这样一共执行了k * nums.length次。
	即第1轮：'1234567'  ->  '7 23456 1'  -> '71 3456 2'  ->  ... 。
2.方法二：注意观察结果，最后一定是( k + (nums.length-k) )的形式。且原本首位两个数紧紧挨着，依次向外扩展。因此，考虑如下变换：
	1234 567 -> 4321 765 -> 5671234。


*/
class Solution {
    public void rotate(int[] nums, int k) {
        if(k > nums.length) k %= nums.length;
        if(k != 0){
            reverse(nums, 0, nums.length - k - 1);
            reverse(nums, nums.length - k, nums.length - 1); 
            reverse(nums, 0, nums.length - 1); 
        }
    }
	
    private void reverse(int[] nums, int head, int tail) {
        int temp;
        while(head <= tail){
            temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            head ++;
            tail --;
        }
    }
}