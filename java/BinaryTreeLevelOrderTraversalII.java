/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

1.采用层序遍历 / 广遍，将第一层节点存储到nodes_now，记录其总数size个；
2.依次remove()掉size个nodes_now中的点，每个remove()掉的节点，都将其值存储到small中，其左右子节点add()到nodes_now；
3.该层remove()结束后，将small插入large的头部，继续处理nodes_now，重复执行1~3的步骤。
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> large = new ArrayList();
        if(root == null){
            return large;
        }else{
            LinkedList<TreeNode> node_now = new LinkedList<TreeNode>();
            node_now.add(root);
            while(!node_now.isEmpty()){
                List<Integer> small = new ArrayList();
                int size = node_now.size();
                for(int i = 0; i < size; i++  ){
                    TreeNode temp = node_now.remove();
                    small.add(temp.val);
                    if(temp.left != null)node_now.add(temp.left);
                    if(temp.right != null)node_now.add(temp.right);
                }
                large.add(0, small);
            }
            return large;
        }
    }
}
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> large = new ArrayList();
        if(root == null){
            return large;
        }else{
            LinkedList<TreeNode> node_now = new LinkedList<TreeNode>();
            List<Integer> small = new ArrayList();
            node_now.add(root);
            int pull = 1;
            int put = 0;
            while(!node_now.isEmpty()){
                TreeNode temp = node_now.poll();
                pull --;
                small.add(temp.val);
                if(temp.left != null){
                    node_now.add(temp.left);
                    put ++;
                }
                if(temp.right != null){
                    node_now.add(temp.right);
                    put ++;
                }
                if(pull == 0){
                    pull = put;
                    put = 0;
                    large.add(0, small);
                    small = new ArrayList();
                }
            }
            return large;
        }
    }
}

        
        