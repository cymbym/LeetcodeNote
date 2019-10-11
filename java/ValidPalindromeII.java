/*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.


1.我的解法：利用双指针，疯狂在迭代中用if else判断，而且还有个标志变量用于确定是否已经删去某个数。12ms。
2.最优解：利用双指针，当存在某个错误的数时，直接调用另一个函数，判断剩下的数是否为纯对称，无需标志变量。3ms。
*/

class Solution {
    int cnt = 1;
    public boolean validPalindrome(String s) {
        char[] c = s.toCharArray();
        return isPalindrome(c, 0, c.length - 1);
    }
    public boolean isPalindrome(char[] c, int head, int tail) {
        if (tail - head <= 1) {
            if (c[head] == c[tail]) return true;
            else return cnt == 1;
        }
        else if (tail - head == 2) {
            if (c[head] == c[tail]) return true;
            else if (c[head] == c[head + 1] || c[head + 1] == c[tail]) return cnt == 1;
            else return false; 
        } 
        else if (tail - head == 3) {
            if (c[head] == c[tail] && c[head + 1] == c[tail - 1]) return true;
            else if (c[head] == c[tail - 1] || c[head] == c[tail] || c[head + 1] == c[tail]) return cnt == 1;
            else return false;
        }
        else {
            if (c[head] == c[tail]) return cnt >= 0 && isPalindrome(c, head + 1, tail - 1);
            else if (c[head] == c[tail - 1] && c[head + 1] == c[tail]) {
                cnt --;
                return cnt >= 0 && (isPalindrome(c, head + 1, tail - 2) || isPalindrome(c, head + 2, tail - 1));
            }else if (c[head] == c[tail - 1]) {
                cnt --;
                return cnt >= 0 && isPalindrome(c, head + 1, tail - 2);
            } else if (c[head + 1] == c[tail]) {
                cnt --;
                return cnt >= 0 && isPalindrome(c, head + 2, tail - 1);
            }
            else return false;                   
        }
    }
}

class Solution {
    public static boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();
        int lf = 0, rt = s.length() - 1;
        while (lf < rt) {
            if (cs[lf] != cs[rt]) return isPalindrome(cs, lf + 1, rt) || isPalindrome(cs, lf, rt - 1);
            lf ++;
            rt --;
        }
        return true;
    }
    
    private static boolean isPalindrome(char[] cs, int start, int end) {
        while (start < end) {
            if (cs[start++] != cs[end--]) return false;
        }
        return true;
    }
}