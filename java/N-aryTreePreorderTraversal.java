/*
Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:

 



 

Return its preorder traversal as: [1,3,5,6,2,4].

 

Note:

Recursive solution is trivial, could you do it iteratively?

1.写个递归函数，前序遍历完事儿。
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    ArrayList<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        order(root);
        return res;
    }
    public void order(Node root) {
        if (root == null) return;
        else {
            res.add(root.val);
            for (Node i : root.children) order(i);
			return;
        }
    }
}

