/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 2^31.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

1。用异或计算出汉明距离，用辗转相除法求出个数。
*/

class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int z = x ^ y;
        while (z > 0) {
            if (z % 2 == 1) res ++;
            z /= 2;
        }
        return res;
    }
}