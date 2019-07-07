/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".

1.解题思路：从10个数中取出num个数的问题，小时有4个数，分钟有6个数.
            转化为组合问题：从小时的4个数中组合出i个数，从分钟的6个数中取出num-i个数。
            组合combination(int[] nums, int cnt, int pos, List<Integer> res, int sum)中，从nums中选cnt个数（cnt为计数器，不断递减），pos为将开始取的位数（不断递增），res为不断迭代后存储的和数。
2.一种简单的写法，遍历所有可能时间，用Integer.bitCount()来计算该数的二进制数位，对应灯数。但时间复杂度大。	
			
*/

class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        int[] hour = {1, 2, 4, 8};
        int[] miniute = {1, 2, 4, 8, 16, 32};
        for(int i = 0; i <= num; i ++){
            List<Integer> hours = new ArrayList<Integer>();
            List<Integer> minutes = new ArrayList<Integer>();
            combination(hour, i, 0, hours, 0);
            combination(miniute, num - i, 0, minutes, 0);
            for(int h : hours){
                if(h <= 11){
                    for(int m : minutes){
                        if(m <= 59) res.add(h + (m < 10 ? ":0" : ":") + m);
                    }
                }
            }
        }
        return res;
    }
	
	private void combination(int[] nums, int cnt, int pos, List<Integer> res, int sum){
        if(cnt == 0){
            res.add(sum);
            return;
        }
        for(int i = pos; i < nums.length; i ++){
            combination(nums, cnt - 1, i + 1, res, sum + nums[i]);
        }
	}
}

class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++){
            for (int m = 0; m < 60; m++){
                if (Integer.bitCount(h * 64 + m) == num){
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;    
    }
}