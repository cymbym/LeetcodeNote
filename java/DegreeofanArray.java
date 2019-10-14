/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.


1.我的解法（8ms）：第一个循环里(nums.length)，用int[] count存储每个数出现的次数，用ArrayList<Integer> set存储出现在最多的数。
            第二个循环里(set.size())，初始化set中每个数的起止点：int[] head，int[] tail。set与head,tail，三者的索引一一对应。
			第三个循环里(nums.length/2)，用分而治之的头尾法：寻找set中每个数的起止点。如果存在这个数，则更新该数的head与tail。
			第四个循环里(set.size())，得到最大的头尾。
			
2.最优解（2ms）：两轮循环，三个数组，第一轮(nums.length)，存储出现次数、第一个出现的位置、最后出现的位置，存储出现最多的次数。
                              第二轮(nums.length)，计算最小位置差。
*/


class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] count = new int[50000];
        int cnt = 0;
        int res = nums.length;
        ArrayList<Integer> set = new ArrayList<Integer>();
        for (int i: nums) {
            count[i] ++;
            if (count[i] > cnt) {
                set.clear();
                set.add(i);
                cnt = count[i];
            } else if (count[i] == cnt) set.add(i);
        }
        if (cnt == 1) return 1;
        int size = set.size();
        int[] head = new int[size];
        int[] tail = new int[size];
        for (int i = 0; i < size; i ++) {
            head[i] = nums.length - 1;
            tail[i] = 0;
        }
        for (int i = 0; i <= nums.length / 2; i ++) {
            int temp = set.indexOf(nums[i]);
            if (temp >= 0) {
                if (head[temp] > i) head[temp] = i;
                if (tail[temp] < i) tail[temp] = i;
            }
            temp = set.indexOf(nums[nums.length - 1 - i]);
            if (temp >= 0) {
                if (head[temp] > nums.length - 1 - i) head[temp] = nums.length - 1 - i;
                if (tail[temp] < nums.length - 1 - i) tail[temp] = nums.length - 1 - i;
            }
        }
        for (int i = 0; i < size; i ++) res = Math.min(res, tail[i] - head[i] + 1);
        return res;
    }
}


class Solution {
    public int findShortestSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i : nums)
            max = Math.max(max, i);

        int[] bucket = new int[max + 1];
        int[] firstIndex = new int[max + 1];
        int[] lastIndex = new int[max + 1];
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
            
            if (bucket[nums[i]] == 1) {
                firstIndex[nums[i]] = i;
                lastIndex[nums[i]] = i;
            } else {
                lastIndex[nums[i]] = i;
            }
            degree = Math.max(degree, bucket[nums[i]]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == degree) {
                res = Math.min(lastIndex[i] - firstIndex[i] + 1, res);
            }
        }
        return res;
    }
}