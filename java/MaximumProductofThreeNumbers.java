/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:

Input: [1,2,3]
Output: 6
 

Example 2:

Input: [1,2,3,4]
Output: 24
 

Note:

1.The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
2.Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

1.我的解法：利用Arrays.sort()先排序，后直接得结果。时间：n*log n。15ms。
2.最优解：在一次循环里，遍历出最大、第二大、第三大、最小、第二小的数，最后得结果。时间：n。1ms。
*/

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        if (nums[1] < 0) max = Math.max(max, nums[nums.length - 1] * nums[0] * nums[1]);
        return max;
    }
}

class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max3){
                if(nums[i] <= max2) {
                    max3 = nums[i];
                }else {
                    if(nums[i] <= max1) {
                        max3 = max2;
                        max2 = nums[i];
                    }else{
                        max3 = max2;
                        max2 = max1;
                        max1 = nums[i];
                    }
                }
            }
            
                if(nums[i] < min2) {
                    if(nums[i] >= min1) {
                        min2 = nums[i];
                    }else{
                        min2 = min1;
                        min1 = nums[i];
                    }
                }
        }
        
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}