/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.

1.我的方法（6ms）：
 先判断结点是否相等：
  a.是的话，调用函数判断二者是否为相等的树，或者调用递归判断子结点与其是否为子树。
    即 if (s.val == t.val) return (isSametree(s.left, t.left) && isSametree(s.right, t.right)) || isSubtree(s.left, t) || isSubtree(s.right, t);
  b.不是的话，直接调用递归判断子结点与其是否为子树。
    即 else return isSubtree(s.left, t) || isSubtree(s.right, t);
2.最优解（1ms）：
   用一个全局变量时刻可以替t。


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