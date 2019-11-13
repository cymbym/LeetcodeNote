/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.


*/

class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        int[] res = new int[A.length];
        for (int a: A) if (a % 2 == 0) sum += a;
        for (int i = 0; i < queries.length; i ++) {
            int tmp = A[queries[i][1]];
            if ((tmp + queries[i][0]) % 2 == 0) {
                if (tmp % 2 == 0) sum += queries[i][0];
                else sum += tmp + queries[i][0];
            } else {
                if (tmp % 2 == 0) sum -= tmp;
            }
            A[queries[i][1]] += queries[i][0];
            res[i] = sum;
        }
        return res;
    }
}