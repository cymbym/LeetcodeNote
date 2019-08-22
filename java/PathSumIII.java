/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

1.我的思路(最优)：创建map用于存储阶段和+target，每个结点的子结点遍历结束后，自行除去存储的数；用count存储个数。
	一旦sum == target（对应根节点算起的和），或者sum == map中出现过的数（对应部分节点算起的和），则count根据出现次数，自加。
2.另一种最优解：创建map用于存储阶段和，用函数返回值存储个数，map采用value的增减来实现更新，返回值也一直在更新。
	注意int count = map.getOrDefault(i, 0)的使用，相当于：if (map.contains(i)) int count =  map.get(i); else int count = 0;


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
    int count;
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap();
        count = 0;
        subSum(root, 0, sum, map);
        return count;
    }    
    private void subSum(TreeNode root, int sum, int target, HashMap<Integer, Integer> map) {
        if (root == null) return;
        else{            
            sum += root.val;
            if (sum == target) count ++;
            count += map.getOrDefault(sum, 0);
            int temp = map.getOrDefault(sum + target, 0);
            map.put(sum + target, temp + 1);
            subSum (root.left, sum, target, map);
            subSum (root.right, sum, target, map);
            map.put(sum + target, temp);
            return;
        }
    }
}

class Solution {
    private static int count;
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        return subSum(root, 0, sum, map);
    } 
    private int subSum(TreeNode root, int sum, int target, HashMap<Integer, Integer> map) {
        if (root == null) return 0;
        else{
            sum += root.val;
            int count = map.getOrDefault(sum - target, 0);  //相当于：if (map.contains(sum - target)) 时，count 等于 sum - target对应的数出现的次数; 否则等于0。
            int temp = map.getOrDefault(sum, 0);
            map.put(sum, temp + 1); 	//相当于：只有从根结点开始累加的和才能参与计数（因为一旦找到对应的path，就将删掉这部分和）。
            count += subSum (root.left, sum, target, map) + subSum (root.right, sum, target, map);
            map.put(sum, temp); 	//相当于：这条path走完后就删了
            return count;
        }
    }
}
0
