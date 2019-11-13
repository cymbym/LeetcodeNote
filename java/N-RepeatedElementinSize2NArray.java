/*
In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.

 

Example 1:

Input: [1,2,3,3]
Output: 3
Example 2:

Input: [2,1,2,5,3,2]
Output: 2
Example 3:

Input: [5,1,5,2,5,3,5,4]
Output: 5
 

Note:

4 <= A.length <= 10000
0 <= A[i] < 10000
A.length is even


1.如果重复的数为多个：直接用数组存储各个数出现的次数，出现次数达到一半即输出。
2.如果重复的数有且只有一个：直接用数组存储各个数出现的次数，则出现两次即输出。

*/

class Solution {
    public int repeatedNTimes(int[] A) {
        int[] map = new int[10000];
        for (int a: A) if (++ map[a] == A.length / 2) return a;
        return 0;
    }
}

class Solution {
    public int repeatedNTimes(int[] A) {
        int[] map = new int[10000];
        for (int a: A) if (++ map[a] > 1) return a;
        return 0;
    }
}