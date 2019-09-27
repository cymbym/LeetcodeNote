/*
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

	
1.在递归中，用前序遍历，根据左右子结点的四种情况进行讨论。
2.我的解法：用了String进行+运算。91ms。
3.最优解：用了StringBuilder对象，进行append运算。1ms。
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
    String res = "";
    public String tree2str(TreeNode t) {
        if (t == null) return res;
        else order(t);
        return res;
    }
    public void order(TreeNode t) {
        res += t.val;
        if (t.left != null) {				//+-
            res += "(";
            order(t.left);
            res += ")";    
            if (t.right != null) {			//++
                res += "(";
                order(t.right);
                res += ")";                
            }
        } else if (t.right != null) {   	//-+
            res += "()(";
            order(t.right);
            res += ")";                
        }
    }
}



class Solution {
    StringBuilder res = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null) return res.toString();
        else order(t);
        return res.toString();
    }
    public void order(TreeNode t) {
        res.append(t.val);
        if (t.left != null) {
            res.append("(");
            order(t.left);
            res.append(")");    
            if (t.right != null) {
                res.append("(");
                order(t.right);
                res.append(")");                
            }
        } else if (t.right != null) {
            res.append("()(");
            order(t.right);
            res.append(")");                
        }
    }
}