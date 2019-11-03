/*
Consider all the leaves of a binary tree. 
 From left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 

Note:

Both of the given trees will have between 1 and 100 nodes.


1.先在一个findLeaf1(root1)里，用DFS来存储每一个叶子结点的值到List<Integer> list1中；
2.随后返回一个findLeaf2(root2)，用DFS来对比每一个叶子结点的值和List<Integer> list1的值。
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
    List<Integer> list1 = new ArrayList<Integer>();
    List<Integer> list2 = new ArrayList<Integer>();
    int cnt;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        cnt = 0;
        findLeaf1(root1);
        return findLeaf2(root2);
    }
    public void findLeaf1(TreeNode root) {
        if (root == null) return;
        else if (root.left == null && root.right == null) list1.add(root.val);
        else {
            findLeaf1(root.left);
            findLeaf1(root.right);
        }
    }
    public boolean findLeaf2(TreeNode root) {
        if (root == null) return true;
        else if (root.left == null && root.right == null) {
            if (list1.get(cnt) != root.val) return false;
            else {
                cnt ++;
                return true;
            }
        }
        else {
            return findLeaf2(root.left) && findLeaf2(root.right);
        }
    }
}