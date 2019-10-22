/*
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.

1.对left到right之间的数，挨个进行判断。							  
*/

class Solution {
    List<Integer> res;
    public List<Integer> selfDividingNumbers(int left, int right) {
        res = new ArrayList<Integer>();
        while (left <= right) {
            if (left % 10 != 0 && isDividingNumbers(left)) res.add(left);
            left ++;
        }
        return res;
    }
    public boolean isDividingNumbers(int num) {
        int temp = num;
        while (temp > 0) {
            int remind = temp % 10;
            if (remind == 0 || num % remind != 0) return false; 
            temp /= 10; 
        }
        return true;
    }
}