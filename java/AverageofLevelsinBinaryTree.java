/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.

1.采用层序遍历。
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
    ArrayList<Double> res = new ArrayList<Double>();
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        cur.add(root);
        order(cur);
        return res;
    }
    public void order(ArrayList<TreeNode> pre) {
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        double sum = 0;
        double cnt = 0;
        for(TreeNode i: pre) {
            if (i != null) {
                sum += i.val;
                cnt ++;
                cur.add(i.left);
                cur.add(i.right);
            }
        }
        if(cnt > 0) {
            res.add(sum / cnt);
            order(cur);
        }
    }
}