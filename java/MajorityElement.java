/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

1.�Լ����뷨��һ��ѭ�����ÿ�����ֳ��ֵĴ����洢��hash���У�һ���ô����������鳤�ȵ�һ�룬�����������ʱ�䣺O(n)��
2.����ʵֻ��Ҫ�����ݽ���һ������Ȼ��ȡ�м��Ǹ�������Ϊ������ʱ�䣺O(nlgn)��

*/

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int temp;
        int len = nums.length / 2;
        for(int num : nums){
            temp = (map.containsKey(num)) ? map.get(num)+1 : 1;
            if(temp > len) return num;
            map.put(num, temp);
        }
        return 0;
    }
}

