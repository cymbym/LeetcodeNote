/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

1.自己的想法是一层循环里，将每个数字出现的次数存储在hash表中，一旦该次数超过数组长度的一半，即输出该数。时间：O(n)。
2.但其实只需要对数据进行一次排序，然后取中间那个数，即为众数。时间：O(nlgn)。

*/

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int temp;
        int len = nums.length / 2;
        for(int num : nums){
            temp = (map.containsKey(num)) ? map.get(num)+1 : 1;
            if(temp > len) return num;
            map.put(num, temp);
        }
        return 0;
    }
}

