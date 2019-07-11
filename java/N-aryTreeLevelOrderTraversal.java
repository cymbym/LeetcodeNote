/*
Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:

 



 

We should return its level order traversal:

[
     [1],
     [3,2,4],
     [5,6]
]
 

Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.


1.我采用广遍，1，3，2，4，5，6。3ms。
2.最优解是深遍中的前序遍历：1，3，5，6，2，4。1ms。
https://www.cnblogs.com/llguanli/p/7363657.html
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> large = new ArrayList();
        if(root == null){
            return large;
        }else{
            LinkedList<Node> node_now = new LinkedList<Node>(); //当前层的结点
            node_now.add(root);
            while(!node_now.isEmpty()){
                List<Integer> small = new ArrayList();
                int size = node_now.size();
                for(int i = 0; i < size; i ++){
                    Node temp = node_now.remove(); //看来数组也是先入先出
                    small.add(temp);
                    if(temp.children != null){
                        for(Node n : temp.children){
                            node_now.add(n);
                        }
                    }
                }
                large.add(small);
            }
            return large;
        }
    }
}



class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        layer(res, 0, root);
        return res;
    }
    
    public void layer(List<List<Integer>> large, int height, Node root) {
        if (height == large.size()) {					//该层，如1，3，5，6
            List<Integer> small = new ArrayList<>();
            small.add(root.val);
            large.add(small);
        } else large.get(height).add(root.val);			//子结点后返回的层，如2，4
        for (Node r : root.children) 
            layer(large, height + 1, r);
    } 
}