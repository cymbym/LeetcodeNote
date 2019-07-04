/*
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.

1.题目中提到对数时间复杂度lgn，该复杂度往往对应于幂次的问题，因此考虑往幂次问题入手。
2.题目 == n!能被几个10整除 == n!能被几个5整除 == 小于等于n的数中存在几个被5的幂次整除的数。
	如30！中存在5，10，15，20，25，30等6个能产生5的数，又25产生两个5，故得再算一次。因此答案为：30/5 + 30/25 = 6 + 1 = 7。
3.注意若temp为int型，则5的某次幂将产生溢出，故改用long型，便没有那么快溢出。

*/

class Solution {
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        long temp = 5;
        while(n/temp != 0){
            count += n/temp;
            temp *= 5;
        }
    return count;
    }
}