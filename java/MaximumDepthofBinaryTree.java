/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

1.��飬����������ʹ�õݹ鼴�ɡ�
2.ԭ������ֱ����Math.max(),������Ŀ�����д�˸��ж�ʽ�����ȴ��ʱ�ˣ�����Math.max()����ͨ����emmmm
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
    public int maxDepth(TreeNode root) {
//         if(root == null){
//             return 0;
//         }else{
//             return maxDepth(root.left) > maxDepth(root.right) ?
// maxDepth(root.left) + 1 : maxDepth(root.right) + 1;  
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;  
    }
}