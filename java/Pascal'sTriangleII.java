/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?

1.因为要求空间复杂度为O(k)，故不能使用递归，只能用单层循环。要想只用单层循环，就得寻找该层各个数字的来源。由于int下，temp * (rowIndex - i + 1)会溢出，因此改用long，最后用(int)转化，而不是int()。
*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>();
        long temp = 1;
        res.add(1);
        for(int i = 1; i < rowIndex; i ++ ){
            temp = temp * (rowIndex - i + 1) / i;
            res.add((int)temp);
        }
        if(rowIndex > 0) res.add(1);
        return res;
    }
}