/*
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a 3-ary tree:

 


 

We should return its max depth, which is 3.

 

Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.

1.我的解法：层序遍历。先遍历该层curr数组，不断存储每层的结点的子结点到数组next中，随后在递归中遍历数组的值（curr=next）。1ms。
2.最优解：层序遍历。每层中都用递归遍历各点最大层数，返回最大值。0ms。
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
    int cnt;
    public int maxDepth(Node root) {
        if (root == null) return 0;
        else {
            cnt = 1;
            List<Node> curr = new ArrayList<Node>();
            curr.add(root);
            getDepth(curr);
            return cnt;
        }
    }
    public void getDepth(List<Node> curr) {
        if (curr.isEmpty()) return;
        else {
            List<Node> next = new ArrayList<Node>();
            for (Node n : curr) {
                if (n.children.isEmpty()) return;
                else for (Node i : n.children) if (! i.children.isEmpty()) next.add(i);
            }
            cnt ++;
            getDepth(next);
            return;
        }
    }
}

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        
        int max = 0;
        List<Node> childs = root.children;
        for (int i = 0; i < childs.size(); i++) {
            int currDepth = maxDepth(childs.get(i));
            if (currDepth > max) {
                max = currDepth;
            }
        }
        
        return max + 1;
    }
}