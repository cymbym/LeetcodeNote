/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

1.我的方法：重复问题+下标需求：用HashMap。8ms。
2.答案：两层循环。0ms？？？


*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i ++){
			if(map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)){
				return true;
			}else{
				map.put(nums[i], i);
			}
		}
		return false;
    }
}


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length==0)
             return false;
         if(nums.length>5000)
             return false;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if(i!=j)
                {
                    if(nums[i]==nums[j])
                    {
                        if(Math.abs(j-i)<=k)
                            return true;
                    }
                }
            }
        }
        return false;
    }
}