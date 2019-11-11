/*
Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]


 

Example 1:

Input: [2,1]
Output: false
Example 2:

Input: [3,5,5]
Output: false
Example 3:

Input: [0,3,2,1]
Output: true
 

Note:

0 <= A.length <= 10000
0 <= A[i] <= 10000 

1.第一种解法：分成了三个区间：初始、递增、递减，逐个判断是否符合要求。2ms。
2.第二种解法：细化了递增区间：
                    即当其中的元素一直递增，则索引直接自加1，当结束递增后，判断是否是数组结束了或者是出现了相等，不是则进入递减区间。1ms。
*/

class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        else {
            int isMountaion = 0;
            for (int i = 1; i < A.length; i ++) {
                if (A[i] == A[i - 1]) return false;
                if (isMountaion == 0) {                          //初始
                    if (A[i] < A[i - 1]) return false;
                    else isMountaion = 1;
                } else if (isMountaion == 1) {                   //递增区间
                    if (A[i] < A[i - 1]) isMountaion = -1;
                } else {                                         //递减区间
                    if (A[i] > A[i - 1]) return false;
                }
            }
            return isMountaion == -1;
        }
    }
}

class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        else {
            boolean isMountaion = false;
            for (int i = 1; i < A.length; i ++) {
                if (A[i] == A[i - 1]) return false;
                if (!isMountaion) {                                            //初始
                    if (A[i] < A[i - 1]) return false;
                    else {
                        while (i < A.length && A[i] > A[i - 1]) i ++;          //递增区间细化
                        if (i >= A.length || A[i] == A[i - 1]) return false;
                        else isMountaion = true;
                    }
                } else {                                                       //递减区间
                    if (A[i] > A[i - 1]) return false;
                }
            }
            return isMountaion;
        }
    }
}