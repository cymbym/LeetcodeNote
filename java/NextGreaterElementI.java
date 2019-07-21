/*
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.


1.用两层循环，第一层遍历nums2的数，第二层遍历该数往后的数直至找到第一个比其大的数，并用HashMap存储起来。

*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (int i = 0; i < nums2.length; i ++) {
            int j = 1;
            while (i + j < nums2.length) {
                if (nums2[i + j] > nums2[i]) {
                    map.put(nums2[i], nums2[i + j]);
                    break;
                }else j ++;
            }
        }
        for (int i = 0; i < nums1.length; i ++) nums1[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        return nums1;
    }
}