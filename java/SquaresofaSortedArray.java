/*
Given an array of integers A sorted in non-decreasing order,
 return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.


1.我的解法：引入双指针，分三种情况讨论：1)全为正：               +   +   +   +   +   +
                                                          head tail

                                        2)全为负：               -   -   -   -   -   -
                                                                                    head tail

                                        3)正负交替：             -   -   -   +   +   +
                                                                       head tail
            无论哪种情况，都让head往小了走，tail往大了走，直至head往左超出0，且tail往右超出A.length-1。
2.另一种解法:其实不用从小的开始存储，直接用双指针从两侧往里游走，先存储大的。
*/

class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int head = 0;
        int tail = 1;
        if (A[0] >= 0) {
            head = -1;
            tail = 0;
        } else if (A[A.length - 1] <= 0) {
            head = A.length - 1;
            tail = A.length;
        } else {
            while (A[tail] < 0) {
                head ++;
                tail ++;
            }
        }
        int cnt = 0;
        while (head >= 0 || tail < A.length) {
            if (head >= 0 && tail < A.length) {                       //head还在负向游走，tail还在正向游走：需比较head和tail大小
                if (A[head] * A[head] == A[tail] * A[tail]) {
                    res[cnt ++] = A[head] * A[head --];
                    res[cnt ++] = A[tail] * A[tail ++];
                } else if (A[head] * A[head] > A[tail] * A[tail]) {
                    res[cnt ++] = A[tail] * A[tail ++];  
                } else if (A[head] * A[head] < A[tail] * A[tail]) {
                    res[cnt ++] = A[head] * A[head --];
                }
            } else if (tail < A.length) {                             //只剩tail还在正向游走：直接存储
                res[cnt ++] = A[tail] * A[tail ++];
            } else if (head >= 0) {                                   //只剩head还在负向游走：直接存储
                res[cnt ++] = A[head] * A[head --];
            }
        }
        return res;
    }
}

class Solution {
    public int[] sortedSquares(int[] A) {
        int left = 0, right = A.length - 1;
        int[] results = new int[A.length];
        int i = A.length - 1;
        while (i >= 0) {
            if (Math.abs(A[left]) < Math.abs(A[right])) {
                results[i] = A[right] * A[right];
                right--;
            } else {
                results[i] = A[left] * A[left];
                left++;
            }
            i --;
        }
        return results;
    }
}