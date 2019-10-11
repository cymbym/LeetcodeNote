/*
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.

 

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output: 2

 

Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output: 2

 

Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.



*/

class Solution {
    public int repeatedStringMatch(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int cnt = 0;
        int m = 0;
        int n = 0;
        for (m = 0; m < a.length; m ++) {                        //case1: 判断"abc"和"c abcabc a"，此处处理"c"。
            if (a[m] != b[n]) {
                m -= n;
                n = 0;
            } else {
                n ++;
            }
            if (n >= b.length && a.length >= b.length) return 1;  //case2: "aaa"和"a"，此处处理完。
        }System.out.println("--");
        m = 0;
        cnt ++;
        if (n == 0) return -1;
        for (n = n; n < b.length; n ++) {                         //case1: 判断"abc"和"c abcabc a"，此处处理"abcabc"和"a"。
            if (a[m] != b[n]) return -1;
            else {
                m ++;
            }
            if (m == a.length) {
                m = 0;
                cnt ++;
            }
        }
        if (m > 0) cnt ++;
        return cnt;
    }
}


class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (B.indexOf(A) == -1) {
            if (A.indexOf(B) != -1) return 1;                  //case1: "aaa"和"aa"，一次就含有B
            else if ((A + A).indexOf(B) != -1) return 2;       //case2: "bba"和"ab" ，累加两次就含有B
            else return -1;                                    //因为如果累加三次以上，才含有B，则B中必含A。如，"abc"和"c abc a"
        }
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int count = 0;
        int m = (a.length - B.indexOf(A)) % a.length;          //case3: 对齐"abc"和"c abcabc a"的"c"
        if (m < 0) return -1;
        for (int n = 0; n < b.length; n++) {                   //case3: 判断"abc"和"c abcabc a"，此处处理"abcabc"和"a"。
            if (m == a.length) {
                m = 0;
                count++;
            }
            if (a[m] != b[n]) return -1;
            m++;
        }
        if (m != 0) count++;
        return count;
    }
}