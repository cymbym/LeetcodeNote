/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

 

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
 

Constraints:

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
Each arr2[i] is distinct.
Each arr2[i] is in arr1.
 
1.用数组int[] cnt存储arr1中每个出现的数及其个数。
2.采用双指针，i逐个获取arr2中的元素，并根据每个元素的个数cnt[arr2[i]]，利用inx更新arr1中的数。
3.若inx未达到arr1的长度，则说明arr1中有元素不在arr2中，此时，挨个从cnt中获取剩余的数，并利用inx继续更新arr1直至inx达到arr1的长度。
*/

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] pos = new int[1001];
        int[] cnt = new int[1001];
        for (int i = 0; i < arr1.length; i ++) cnt[arr1[i]] ++;
        int inx = 0;
        for (int i = 0; i < arr2.length; i ++) {
            while (cnt[arr2[i]] > 0) {
                arr1[inx ++] = arr2[i];
                cnt[arr2[i]] --;
            }
        }
        if (inx < arr1.length) {
            for (int i = 0; i < cnt.length; i ++) {
                while (cnt[i] > 0) {
                    arr1[inx ++] = i;
                    cnt[i] --;
                }
                if (inx > arr1.length) return arr1;
            }
        }
        return arr1;
    }
}