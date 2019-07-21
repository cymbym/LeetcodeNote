/*
Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.

1.我的：先将原始值存储到HashMap中，后用Arrays.sort()进行排序，最后对应输出。6ms。
2.最优解：1ms。

*/




class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i ++) map.put(nums[i], i);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            res[map.get(nums[i])] = intToStr(i, nums.length);
        }
        return res;
    }
    private String intToStr(int num, int len) {
        if (num == len - 1) return "Gold Medal";
        else if (num == len - 2) return "Silver Medal";
        else if (num == len - 3) return "Bronze Medal";
        else return "" + (len - num);
    }
}

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        int max = 0;
        for (int i : nums) {
            if (i > max) max = i;
        }
        int[] hash = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]] = i + 1;
        }
        int place = 1;
        for (int i = hash.length - 1; i >= 0; i--) {
            if (hash[i] != 0) {
                if (place == 1) {
                    result[hash[i] - 1] = "Gold Medal";
                } else if (place == 2) {
                    result[hash[i] - 1] = "Silver Medal";
                } else if (place == 3) {
                    result[hash[i] - 1] = "Bronze Medal";
                } else {
                    result[hash[i] - 1] = place + "";
                }
                place++;
            }
        }
        return result;
    }
}