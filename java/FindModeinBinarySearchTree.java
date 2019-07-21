/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2
 

return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

1.我的解法：在树中采用深度优先遍历的前序遍历（根结点 ---> 左子树 ---> 右子树），
            并用HashMap存储每个结点的值，及各个值出现的次数。并同时统计出现最多的次数。
			随后在递归函数之外，取出这个最大次数对应的值。
2.最优解：忽视了这个二叉搜索树的性质：左结点 <= 根节点 <= 右结点。
          因此深度优先遍历的中序遍历（左子树 ---> 根结点 ---> 右子树），等价于将这些结点进行排序处理。
		  故可以直接在遍历中获取出现最多的值，无需像我的解法中，将其视为乱序。


PS：之前多用前序遍历，preorder traversal，根左右。 此处中序遍历，inorder traversal，左根右。后序遍历，postorder traversal，左右根。	
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
    private int maxValue;
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap();
        saveMap(root, map);
        for (int key : map.keySet()) if (map.get(key) == maxValue) res.add(key);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i ++) ans[i] = res.get(i);
        return ans;
    }  
    private void saveMap(TreeNode root, HashMap<Integer, Integer> map) {
        int temp = 0;
        if (root != null) {
            temp = map.getOrDefault(root.val, 0) + 1;
            maxValue = (maxValue > temp) ? maxValue : temp;
            map.put(root.val, temp);
            if (root.left != null) saveMap(root.left, map);
            if (root.right != null) saveMap(root.right, map);
        }
        return;
    }
}

class Solution {
    private Integer prev = null;
    private int count = 1;
    private int countMax = 0;
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        saveList(root, res);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i ++) ans[i] = res.get(i);
        return ans;
    }
   
    private void saveList(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;
        saveList(root.left, res);
        if (prev != null) {
            if (root.val == prev) count++;
            else count = 1;
        }
        if (count > countMax) {
            countMax = count;
            res.clear();
            res.add(root.val);
        } else if (count == countMax) res.add(root.val);
        prev = root.val;
        saveList(root.right, res);
    }
}