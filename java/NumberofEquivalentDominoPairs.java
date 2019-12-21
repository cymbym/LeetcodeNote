/*
Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d]
 if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

 

Example 1:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
 

Constraints:

1 <= dominoes.length <= 40000
1 <= dominoes[i][j] <= 9


1.由于只要两数相等即可，不考虑顺序，因此便考虑将其转化为一个11~99的数字，且大的放十位，小的放个位。
2.随后遍历重复出现的数，并对其构造2的组合数，累加到结果。
*/

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] cnt = new int[100];
        for (int[] d: dominoes) {
            if (d[0] >= d[1]) cnt[d[0] * 10 + d[1]] ++;
            else cnt[d[1] * 10 + d[0]] ++;
        }
        int res = 0;
        for (int c: cnt) if (c > 1) res += c *(c - 1) / 2;
        return res;
    }
}