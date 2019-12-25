/*
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements. 

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr
 

Example 1:

Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
Example 2:

Input: arr = [1,3,6,10,15]
Output: [[1,3]]
Example 3:

Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]
 

Constraints:

2 <= arr.length <= 10^5
-10^6 <= arr[i] <= 10^6


1.我的解法：先用冒泡排序，并在排序中统计最小的差距，随后挨个寻找差距相同的数。但超时了。
2.较优解：直接用Arrays.sort(arr);，并另外在一个循环中统计最小差距。
*/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(arr); // sort ascending
        int min = Math.abs(arr[1] -  arr[0]);
        
        for (int i = 1; i<arr.length; i++) 
            min = Math.abs(arr[i] - arr[i-1]) < min ? Math.abs(arr[i] - arr[i-1]) : min;
        for (int i = 0; i < arr.length - 1; i ++) {
            if (arr[i] + min == arr[i + 1])  {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(arr[i]);
                tmp.add(arr[i + 1]);
                res.add(tmp);
            }
        }
        return res;
    }
}