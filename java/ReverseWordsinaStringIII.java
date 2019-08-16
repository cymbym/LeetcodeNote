/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.

1.最开始：考虑了一开始可能遇到(连续)空格，跳过；中间判断空格，置换；置换后判断连续空格，跳过；最后判断结局：置换。3ms。
2.后来：把这些连续空格的判断去除，时间优化。2ms。
3.最优解：中间多了个函数判断空格，时间优化。1ms。
4.对比最优解：去掉该函数，时间复杂。3ms。


*/


class Solution {
    char[] c;
    public String reverseWords(String s) {
        int head = 0;
        char[] temp = s.toCharArray();
        while (head < temp.length && temp[head] == ' ') head ++;
        c = (head > 0) ? s.substring(head, temp.length).toCharArray() : temp;
        head = 0;
        for (int i = 0; i < c.length; i ++) {
            if (c[i] == ' ') {
                reverseWord(head, i - 1);
                i ++;
                head = i;
                while (i < c.length && c[i] == ' ') {
                    i ++;
                    head = i;
                }
            }
        }
        if (head < c.length - 1) reverseWord(head, c.length - 1);
        return new String(c);
    }
    public void reverseWord(int head, int tail) {
        while (head < tail) {
            char temp = c[tail];
            c[tail] = c[head];
            c[head] = temp;
            head ++;
            tail --;
        }
    }
}

class Solution {
    char[] c;
    public String reverseWords(String s) {
        int head = 0;
        c = s.toCharArray();
        for (int i = 0; i < c.length; i ++) {
            if (c[i] == ' ') {
                reverseWord(head, i - 1);
                i ++;
                head = i;
            }  
        }
		reverseWord(head, c.length - 1);
        return new String(c);
    }
    public void reverseWord(int head, int tail) {
        while (head < tail) {
            char temp = c[tail];
            c[tail] = c[head];
            c[head] = temp;
            head ++;
            tail --;
        }
    }
}

class Solution {
    char[] c;
    public String reverseWords(String s) {
        c = s.toCharArray();
        for(int i =0;i<c.length;){
            int space = getNextSpace(c, i);
            reverseWord(c, i, space-1);
            i = space+1;
        }
        return new String(c);
    }
    public int getNextSpace(char s[], int start){
        while(start<s.length){
            if(s[start]==' ')
                return start;
            start++;
        }
        return start;
    }
    public void reverseWord(char[] c, int head, int tail) {
        while (head < tail) {
            char temp = c[tail];
            c[tail] = c[head];
            c[head] = temp;
            head ++;
            tail --;
        }
    }
}

class Solution {
    char[] c;
    public String reverseWords(String s) {
        c = s.toCharArray();
        for(int i =0;i<c.length;){
            int space = i;
            while(space<c.length){
                if(c[space]==' ')
                    break;
                space++;
            }
            reverseWord(c, i, space-1);
            i = space+1;
        }
        return new String(c);
    }
    public void reverseWord(char[] c, int head, int tail) {
        while (head < tail) {
            char temp = c[tail];
            c[tail] = c[head];
            c[head] = temp;
            head ++;
            tail --;
        }
    }
}