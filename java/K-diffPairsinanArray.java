/*
Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].

1.我的：第一次循环用哈希表存储数据和出现的次数；第二次循环遍历比该数大k的数， 
        k>0直接累加(如Ex1,2)，k=0且该数出现多次才累加(如Ex3)。9ms。
2.最优解：第一次循环中实现排序；第二次用双指针一前一后遍历，寻找间隔为k的数。4ms。
*/


class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(nums[i] + k)) {
                if (k > 0) res ++;
                else if (map.get(nums[i] + k) > 1) res ++;
                map.remove(nums[i] + k);
            }
        }
        return res;
    }
}

class Solution {
    public int findPairs(int[] nums, int k) {
        if(k<0 || nums.length<=1){
	    return 0;
	}
		 
         Arrays.sort(nums);
         int count = 0;
         int left = 0;
         int right = 1;
         
         while(right<nums.length){
             int firNum = nums[left];
             int secNum = nums[right];
             // If less than k, increase the right index
             if(secNum-firNum<k){
                 right++;
             }
             // If larger than k, increase the left index
             else if(secNum - firNum>k){
                 left++;   
             }
             // If equal, move left and right to next different number
             else{
                 count++;
                 while(left<nums.length && nums[left]==firNum){
                     left++;
                 }
                 while(right<nums.length && nums[right]==secNum){
                     right++;
                 }
                             
             }
             //left and right should not be the same number
             if(right==left){
             	right++;
             }
         }
        return count;
    }
}