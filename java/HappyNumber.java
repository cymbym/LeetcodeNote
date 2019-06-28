/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

1.自己的方法，将每次得到的数存储在set中，一旦重复出现或者得到的数出现1，则终止。时间复杂度最大，2ms。
2.类似之前环的问题里，快慢指针的做法，一旦二者重合，则表示出现重复的数了；一旦出现0，也可进行终止。1ms。
3.首先观察死循环中必会出现4，因此采用递归。0ms。

*/

class Solution {
    public boolean isHappy(int n) {
		Set set=new HashSet();
		while(n != 1){
			set.add(n);
			n = toAnswer(n);
			if(set.contains(n)) return false;
		}
		return true;
    }
	private int toAnswer(int n){
		int sum = 0;
		while(n != 0){
			int temp = n % 10;
			sum += Math.pow(temp, 2);
			n /= 10;
		}
		return sum;
	}
}

class Solution {
    public boolean isHappy(int n) {
		int slow = n, fast = n;
        while (true) {
            slow = toAnswer(slow);
            fast = toAnswer(fast);
            fast = toAnswer(fast);
            if (slow == fast) break;
        }
        return slow == 1;
    }
	private int toAnswer(int n){
		int res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}

class Solution {
     public boolean isHappy(int n) {
        if (n == 1) return true;
        if (n == 4 || n < 1) return false;
        int res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return isHappy(res);   
    }
}

