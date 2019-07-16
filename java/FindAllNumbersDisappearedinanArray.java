/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

1.由于不允许使用额外的空间，因此只能在原数组上做文章。思路是将原数组出现的数字作为索引，映射到数组对应的值，将值加一个固定的数（如数组长度）或将其变成负数。
  只有出现了的数字，经过此番操作后，其对应的值才能超过这个固定的数或者才能变成负数。因此取出不符合此番变换的数即可。
  如[4, 3, 2, 7, 8, 2, 3, 1]，变成了 [12, 19, 18, 15, 8, 2, 11, 9]或[-4, -3, -2, -7, 8, 2, -3, -1]
  
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i ++) nums[(nums[i] - 1) % nums.length] += nums.length;
        for (int i = 0; i < nums.length; i ++) if(nums[i] <= nums.length) res.add(i + 1);
        return res;
    }
}