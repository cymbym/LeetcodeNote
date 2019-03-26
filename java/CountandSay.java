/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

1.之前用的方法是迭代，不断得到前一个数对应的字符串，然后进行处理，但时间复杂度却出奇高；
2.看到最佳的答案是将迭代换成一个函数，循环处理这个函数。

public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            s = countIdx(s);
        }
        return s;
    }
    
    public String countIdx(String s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }
            else
            {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}

*/

class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }else if(n == 2){
            return "11";
        }else{
            String s = countAndSay(n-1);
            int len = s.length();
            int count = 1;
            String temp = s.substring(0, 1);
            String temp_2 = "";
            String ans = "";
            for(int i = 1; i < len; i ++){
                temp_2 = s.substring(i, i+1);
                if(temp.equals(temp_2) == true){
                    count ++;
                }else{
                    ans = ans + count + temp;
                    temp = temp_2;
                    count = 1;
                }
            }
            ans = ans + count + temp;
            return ans;
        }        
    }
}