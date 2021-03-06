/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.

1.我是在sumRange中每次重新算和。
2.最优解是在构造方法中算和，将每次的和都存在数组中，最后按需减去即可。

*/

class NumArray {
    private int[] list;
    public NumArray(int[] nums) {
        list = nums;
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        for(int k = i; k <= j; k ++){
            sum += nums[k];
        }
        return sum;
    }
}

class NumArray {
    private int[] sum = new int[nums.length+1];
    public NumArray(int[] nums) {
        for(int k = 0; k < nums.length; k ++){
            sum[k+1] = sum[k] + nums[k];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */