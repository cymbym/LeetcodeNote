/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

1.深度遍历。


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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root == null){
            return list;
        }else if(root.left == null && root.right == null){
            list.add("" + root.val);
            return list;
        }else if(root.left == null){
            list = binaryTreePaths(root.right);
            for(int i = 0; i < list.size(); i ++){
                list.set(i, root.val + "->" + list.get(i));
            }
            return list;
        }else if(root.right == null){
            list = binaryTreePaths(root.left);
            for(int i = 0; i < list.size(); i ++){
                list.set(i, root.val + "->" + list.get(i));
            }
            return list;
        }else{
            list = binaryTreePaths(root.left);
            for(int i = 0; i < list.size(); i ++){
                list.set(i, root.val + "->" + list.get(i));
            }
            List<String> list_right = new ArrayList<String>();
            list_right = binaryTreePaths(root.right);
            for(int i = 0; i < list_right.size(); i ++){
                list.add(root.val + "->" + list_right.get(i));
            }
            return list;
        }
    }
}

