/*
Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
 and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
Note:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.

1.BST的中序遍历等于排序。
2.在中序遍历过程中，注意学习如何给head赋值及迭代：
         root.left = null;  //直接利用已有的root，其走过的左结点没有利用价值，直接赋值为null
         head.right = root; //右结点直接赋值为当前结点
         head = head.right; //迭代
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
    TreeNode head;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return root;
        else {
            head = new TreeNode(-1);
            TreeNode res = head;
            order(root);
            return res.right;
        }
    }
    public void order(TreeNode root) {
        if (root == null) return;
        else {
            order(root.left);
            root.left = null;
            head.right = root;
            head = head.right;
            order(root.right);
        }
    }
}