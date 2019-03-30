/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

1.��������nums1���洢����������nums1��ͷ��ʼ�洢���Ὣ�串�ǵ�����˿����ɴ�С�洢��nums1��β����ͷ��
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 1, j = 1;
        while(i <= m && j <= n){
            if(nums1[m - i] >= nums2[n - j]){
                nums1[m + n + 1 - i - j] = nums1[m - i];
                i ++ ;
            }else{
                nums1[m + n + 1 - i - j] = nums2[n - j];
                j ++ ;
            }
        }
        if(i > m){
            while(j <= n){
                nums1[m + n + 1 - i - j] = nums2[n - j];
                j ++ ;
            }
        }
    }
}