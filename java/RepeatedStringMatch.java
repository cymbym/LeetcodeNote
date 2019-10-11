/*
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.


1.我的解法：想先将A的尾部和B对齐，随后用完整的A和剩余的B逐个对应，最后对应A的头和剩余的B。
      如"abc"和"c abcabc a" 或者 "aaa"和"a"，都可以成功。
      但是遇到这种就不行："aabaa"和"aaab"，它把A的尾部视为aa，而不是a，导致后面无法对齐。报错。
	  
2.最优解：必须明白，一旦B中含有A，则必可通过累加A三次及以上，使得B含于其中。因此，分两种情况：
      B中不含A：B小于A 且 一个A便直接含有B；
	            A累加两次，含有B；
				A中永远不能含B。
	  B中含A：类似我的解法。
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