/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.

1.��顣���ӽڵ��õݹ顣
2.ע����Ҷ�ӽڵ㵽���ڵ�ľ��룬��������Ӧ����5��������1������Ӧ����root.left == null || root.right == null�������ʱզ�졣
Given binary tree [1,2,null,3,null,4,null,5],

            1
		   /
		  2
		 /
        3
	   /
	  4
	 /
	5
	
return its minimum depth = 5.


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
    public int minDepth(TreeNode root) {
        if(root == null || root == null){
			return 0;
		}else if(root.left == null && root.right == null){
            return 1;
        }else if(root.left == null || root.right == null){
            return Math.max(minDepth(root.left), minDepth(root.right))+1;
        }else{
			return Math.min(minDepth(root.left), minDepth(root.right))+1;
		}	
    }
}