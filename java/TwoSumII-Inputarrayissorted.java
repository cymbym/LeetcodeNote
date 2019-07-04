/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

1.一开始和two sum一样用的hash表，但此处的numbers是有序的，因此时间复杂度比别人高。
2.采样双指针的方法，分别指向首位，取其和，随后往中间遍历。

*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int head = 1;
        int tail = numbers.length;
        int sum;
        while(head < tail){
            sum = numbers[head - 1] + numbers[tail - 1];
            if(sum == target){
                return new int[]{head, tail};
            }else if(sum < target){
                head ++;
            }else{
                tail --;
            }
        }
        return null;
    }
}