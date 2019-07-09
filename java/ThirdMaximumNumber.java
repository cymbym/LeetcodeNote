/*
Given a non-empty array of integers, return the third maximum number in this array.
 If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

1.用三个数分别存储最大，第二大，第三大的数。一开始用了int的极小值来作为这三个数的下界。
2.但是一旦nums中存在这个极小值，第三大究竟是这个极小值，还是没有出现第三大，其仍为初始值，将无法判断。因此采用long，扩大下界。

*/

class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for(int i : nums){
            if(i > first){
                third = second;
                second = first;
                first = i;
            }else if(i > second && i < first){
                third = second;
                second = i;
            }else if(i > third && i < second){
                third = i;
            }
        }
        return third == Long.MIN_VALUE ? (int)first : (int)third;
    }
}