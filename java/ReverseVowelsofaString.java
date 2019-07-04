/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".

1.我采用了HashSet存储所有元音字母，使用双指针进行比较，一旦出现，则替换。4ms。
2.最优解同样运用了双指针，但是采用的是数组存储元音字母，看来还是尽可能用数组吧。1ms。

*/



class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');set.add('A');
        set.add('e');set.add('E');
        set.add('i');set.add('I');
        set.add('o');set.add('O');
        set.add('u');set.add('U');
        char[] c = s.toCharArray();
        int head = 0;
        int tail = c.length - 1;
        while(head < tail){
            while(head < tail && !set.contains(c[head])){
                head ++;
            }
            while(head < tail && !set.contains(c[tail])){
                tail --;
            }
            if(head < tail){
                char temp = c[head];
                c[head] = c[tail];
                c[tail] = temp;
                head ++;
                tail --;
            }
        }
        return String.valueOf(c);
    }
}

class Solution {
    public String reverseVowels(String s) {
        char[] vow = {'a','e','i','o','u','A','E','I','O','U'};
        boolean[] v = new boolean[256];
        for (char c : vow){
            v[c] = true;
        }
        char[] cs = s.toCharArray();
        int l = 0;
        int r = cs.length - 1;
        while (l < r){
            while (l < r && !v[cs[l]]){
                l++;
            }
            while (l < r && !v[cs[r]]){
                r--;
            }
            char temp = cs[l];
            cs[l] = cs[r];
            cs[r] = temp;
            l++;
            r--;
        }
        return new String(cs);
    }
}