/*
Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].


1.关于两数之和，要返回某两数的索引，在java中可以考虑利用【数值+索引位置->建立hash表】。
2.关于这种遍历寻找两数的问题，可以考虑【一边遍历，一边建立hash表】。
*/



class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap map = new HashMap();
        int s[] = new int[2];
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                s[0] = i;
                s[1] = (int)map.get(temp);
                return s;
            }
            map.put(nums[i], i);
        }
        return s;
    }
}
