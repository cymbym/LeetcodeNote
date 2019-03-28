/*
Share
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

1.纯数组运算
*/

class Solution {
    public int[] plusOne(int[] digits) {
        
        int i = digits.length - 1;
        int flag = 0;
        while(i >= 0){
            if(digits[i] != 9){
                digits[i] += 1;
                flag = 0;
                break;
            }else{
                digits[i] = 0;
                flag = 1;
            }
            i -- ;
        }if(flag == 1){
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            System.arraycopy(digits, 0, ans, 1, digits.length);
            return ans;
        }else{
            return digits;
        }
    }
}
                