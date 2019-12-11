/*
Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i]
 interpreted as a binary number (from most-significant-bit to least-significant-bit.)

Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.

Example 1:

Input: [0,1,1]
Output: [true,false,false]
Explanation: 
The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
  Only the first number is divisible by 5, so answer[0] is true.
Example 2:

Input: [1,1,1]
Output: [false,false,false]
Example 3:

Input: [0,1,1,1,1,1]
Output: [true,false,false,false,true,false]
Example 4:

Input: [1,1,1,0,1]
Output: [false,false,false,false,false]
 

Note:

1 <= A.length <= 30000
A[i] is 0 or 1

1.我的解法：挨个存储，新数=前者*2+该数，即新数tmp=2*tmp+a;。但溢出了，用long也无济于事。
2.修正版：直接tmp=(2*tmp+a)%5;获得余数版的新数。
          令tmp=5*t+r，则法1中的新数tmp=2*tmp+a=10*t+2*r+a，新数的余数为(2*r+a)%5。
		  比较余数版的新数，取余后同样为(2*r+a)%5。
*/

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<Boolean>();
        long tmp = 0;
        for (int a: A) {
            tmp = 2 * tmp + a;
            res.add(tmp % 5 == 0);
        }
        return res;
    }
}

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<Boolean>();
        long tmp = 0;
        for (int a: A) {
            tmp = (2 * tmp + a) % 5;
            res.add(tmp == 0);
        }
        return res;
    }
}