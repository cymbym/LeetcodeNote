/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.


*/



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return t == null;
        else if (t == null) return false;
        else {
            if (s.val == t.val) return (isSametree(s.left, t.left) && isSametree(s.right, t.right)) || isSubtree(s.left, t) || isSubtree(s.right, t);
            else return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }
    public boolean isSametree(TreeNode s, TreeNode t) {
        if (s == null) return t == null;
        else if (t == null) return false;
        else {
            if (s.val == t.val)  return isSametree(s.left, t.left) && isSametree(s.right, t.right);
            else return false;
        }
    }
}

class Solution {
    TreeNode t0;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        this.t0 = t;
        return is(s, t);
    }
    public boolean is(TreeNode s, TreeNode t){
        if(s == null) return t == null;
        if(t == null) return false;
        if(s.val == t.val) {
            return (is(s.left, t.left) && is(s.right, t.right)) || is(s.left, t) || is(s.right, t);
        }
        return isSubtree(s.left, t0) || isSubtree(s.right, t0); //此处如果用t，这个t有可能是来自上述is(s.left, t.left)中的t.left，就不能将一切归零，重新对应了。
    }
}