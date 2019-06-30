/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

1.第一反映是想到用递归，但是用啥去递归，显然直接用左右子树是不行的。
2.解题关键：p.left = root.left.left;
            p.right = root.right.right;
            q.left = root.left.right;
            q.right = root.right.left;
	由于该问题是对称问题，因此利用左节点的左枝与右节点的右枝构造树p，左节点的右枝与右节点的左枝构造树q，分别判断p、q即可
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }else{
            if(root.left == null && root.right == null){
                return true;
            }else if(root.left == null || root.right == null){
                return false;
            }else{
                if(root.left.val != root.right.val){
                    return false;
                }else{
                    TreeNode p = new TreeNode(-1), q = new TreeNode(-1);
                    p.left = root.left.left;
                    p.right = root.right.right;
                    q.left = root.left.right;
                    q.right = root.right.left;
                    return isSymmetric(p) && isSymmetric(q);
                }
            }
        }
    }
}
 