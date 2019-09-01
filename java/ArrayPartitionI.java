/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].

1.我的解法：因为最终结果必是一对对中的较小值。用Arrays.sort(nums);进行排序得到各个对。13ms。
2.我的解法2：想到库函数可能也进行了两层循环，便直接在两层循环里找出各个对中的那个较小值。但时间却炸了。看来Arrays.sort比自己写快。
3.最优解：用数组当作map，然后就各自if else，但其实也是两两存一个。3ms。


*/



class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length; i += 2) res += nums[i];
        return res;
    }
}


class Solution {
    public int arrayPairSum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < nums.length - i - 1; j ++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            System.out.println(nums[nums.length - 1 - i]);
            res += i % 2 != 0 ? nums[nums.length - 1 - i] : 0;
        }
        return res;
    }
}

class Solution {
    public int arrayPairSum(int[] nums) {
        int[] table = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            table[nums[i] + 10000]++;
        }
        int sum = 0, pnt = 0;
        for (int i = 0; i < 20001; i++) {
            if (table[i] == 0) continue;
            if (pnt == 0) {
                if ((table[i] & 1) == 0) {
                    sum += (table[i] / 2) * (i - 10000);
                } else {
                    sum += ((table[i] + 1) / 2) * (i - 10000);
                    pnt = 1;
                }
            } else {
                if ((table[i] & 1) == 0) {
                    sum += (table[i] / 2) * (i - 10000);
                } else {
                    sum += (table[i] / 2) * (i - 10000);
                    pnt = 0;
                }
            }
        }
        return sum;
    }
}