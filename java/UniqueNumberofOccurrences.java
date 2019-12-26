/*
Given an array of integers arr, write a function that returns true
 if and only if the number of occurrences of each value in the array is unique.

 

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1.
 No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 

Constraints:

1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000

1.int[] cnt统计各数字出现的频次。
2.int[] one统计各频次出现的次数。若某频次出现超过两次，则报错。
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] cnt = new int[2001];
        for (int a: arr) cnt[a + 1000] ++;
        int[] one = new int[1000];
        for (int c: cnt) {
            if (c > 0) one[c] ++;
            if (one[c] > 1) return false;
        }
        return true;
    }
}