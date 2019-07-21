/*
Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].

1.我：辗转相除。
2.最优解：return Integer.toString(num, 7);

*/




class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        else {
            StringBuffer res = new StringBuffer();
            boolean flag = false;
            if (num < 0) {
                num = - num;
                flag = true;
            }
            while (num != 0) {
                res.insert(0, num % 7);
                num /= 7;
            }
            if (flag) res.insert(0, "-");
            return res.toString();
        }
    }
}

class Solution {
    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
}