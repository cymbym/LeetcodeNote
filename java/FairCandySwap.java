/*
Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has,
 and B[j] is the size of the j-th bar of candy that Bob has.

Since they are friends, they would like to exchange one candy bar each so that after the exchange,
 they both have the same total amount of candy.
  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)

Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange,
 and ans[1] is the size of the candy bar that Bob must exchange.

If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.

 

Example 1:

Input: A = [1,1], B = [2,2]
Output: [1,2]
Example 2:

Input: A = [1,2], B = [2,3]
Output: [1,2]
Example 3:

Input: A = [2], B = [1,3]
Output: [2,3]
Example 4:

Input: A = [1,2,5], B = [2,4]
Output: [5,4]
 

Note:

1 <= A.length <= 10000
1 <= B.length <= 10000
1 <= A[i] <= 100000
1 <= B[i] <= 100000
It is guaranteed that Alice and Bob have different total amounts of candy.
It is guaranteed there exists an answer.



1.用数组存储A出现的数，利用和的差值在B中挨个寻找能交换的数，并判断该数是否在B中。
*/

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        boolean[] mapA = new boolean[100001];
        int res[] = new int[2];
        int diffB = 0, sumA = 0, sumB = 0;
        for (int a: A) {
            sumA += a;
            mapA[a] = true;
        }
        for (int b: B) {
            sumB += b;
        }
        diffB = (sumB - sumA) / 2;
        for (int b: B) {
            if (b - diffB > 0 && b - diffB < 100001 && mapA[b - diffB]) {
                res[0] = b - diffB;
                res[1] = b;
                return res;
            }
        }
        return res;
    }
}