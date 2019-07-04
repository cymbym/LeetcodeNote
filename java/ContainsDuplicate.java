/*
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true

1.我的方法：重复元素问题用HashSet。9ms。
2.答案：先用Arrays.sort(nums)排序，随后遍历。3ms。

*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set set = new HashSet();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }else{
                set.add(num);
            }
        }
        return false;
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 0) {
            return false;
        }
        Arrays.sort(nums);
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev == nums[i])
                return true;
            prev = nums[i];
        }
        return false;
    }
}