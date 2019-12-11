/*
Given an array A of integers, we must modify the array in the following way:
 we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.
 (We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.

 

Example 1:

Input: A = [4,2,3], K = 1
Output: 5
Explanation: Choose indices (1,) and A becomes [4,-2,3].
Example 2:

Input: A = [3,-1,0,2], K = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
Example 3:

Input: A = [2,-3,-1,5,-4], K = 2
Output: 13
Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 

Note:

1 <= A.length <= 10000
1 <= K <= 10000
-100 <= A[i] <= 100

1.我的解法：利用冒泡先进行排序，同时统计负数的个数、是否出现0、最大负数、最小正数。  11ms。
            随后利用K来判断是挨个消掉负数、还是利用0、亦或者绝对值最小的数。
2.最优解：利用所有数范围在-100到100，构建一个长度为200的数组，存储各个数出现的个数，同时统计最大负数、最小正数。  1ms。
          随后在0到200的区间内，挨个判断消去的数。	
*/

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int cntNeg = 0;
        int cntZero = 0; 
        int sum = 0; 
        int minNeg= - Integer.MAX_VALUE;
        int minPos = Integer.MAX_VALUE;
        for (int i = A.length - 1; i >= 0; i --) {
            for (int j = A.length - 1; j >= A.length - i; j --) {
                if (A[j] < A[j - 1]) {
                    int tmp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = tmp;
                }
            }
            if (A[A.length - i - 1] < 0) {
                cntNeg ++;
                if (A[A.length - i - 1] > minNeg) minNeg = A[A.length - i - 1];
            }
            else if (A[A.length - i - 1] == 0) cntZero ++;
            else {
                if (A[A.length - i - 1] < minPos) minPos = A[A.length - i - 1];
            }
            sum += A[A.length - i - 1];
        }
        int index = 0;
        while (K > 0) {
            if (cntNeg > 0) {
                sum -= 2 * A[index];
                index ++;
                cntNeg --;
                K --;
            } else {
                if (cntZero > 0 || K % 2 == 0) return sum;
                else {
                    int tmp = Math.min(-minNeg, minPos);
                    sum -= 2 * tmp;
                    return sum;
                }
            }
        }
        return sum;
    }
}


class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int [] B = new int[201];
        int numOfP = 0;
        int numOfN = 0;
        int minP = Integer.MAX_VALUE;
        int maxN = Integer.MIN_VALUE;
        for(int a : A) {
            if(a > 0) {
                numOfP ++;
                minP = Math.min(minP, a);
            } else if(a < 0) {
                numOfN ++;
                maxN = Math.max(maxN, a);
            }
            B[a + 100] ++;
        }
        
        if(numOfN == 0) {
            int sum = 0;
            for(int i = 100; i < 201; i ++) {
                sum += (i - 100) * B[i];
            }
            if(B[100] > 0) {
                return sum;
            } else {
                return sum - 2 * minP;
            }
        } else {
            int sum = 0;
            for(int i = 100; i < 201; i ++) {
                sum += (i - 100) * B[i];
            }
            if(K == numOfN) {
                for(int i = 0; i < 100; i ++) {
                    sum += (100 - i) * B[i];
                }
                return sum;
            } else if(K < numOfN) {
                for(int i = 0; i < 100; i ++) {
                    if(K == 0) {
                        sum += (i - 100) * B[i];
                    } else if(K >= B[i]) {
                        sum += (100 - i) * B[i];
                        K -= B[i];
                    } else {
                        sum += (i - 100) * (B[i] - 2 * K);
                        K = 0;
                    }
                }
                return sum;
            } else {
                for(int i = 0; i < 100; i ++) {
                    sum += (100 - i) * B[i];
                }
                K -= numOfN;
                if(K % 2 == 0 || B[100] > 0) return sum;
                if(minP + maxN >= 0) {
                    return sum + maxN * 2;
                } else {
                    return sum - minP * 2;
                }
            }
        }
//        return sum;
    }
}