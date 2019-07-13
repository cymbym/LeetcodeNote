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

1.我的思路：创建set用于存储阶段和，用整数存储个数，set不能一直更新，只能在递归中更新，整数应该一直更新。
	但实际情况是：作为方法中的实参，数组、map等对象是不断更新的，而整数等基本数据类型却是不变的（形参才会变）。且无法确定set中key的个数。
2.最优解：创建map用于存储阶段和，用函数返回值存储个数，map采用value的增减来实现更新，返回值也一直在更新。
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
            map.put(sum, map.getOrDefault(sum, 0) + 1); 	//相当于：只有从根结点开始累加的和才能参与计数（因为一旦找到对应的path，就将删掉这部分和）。
            count += subSum (root.left, sum, target, map) + subSum (root.right, sum, target, map);
            map.put(sum, map.get(sum) - 1); 	//相当于：这条path走完后就删了
            return count;
        }
    }
}

/*
wrongAns:
class Solution {
    public int pathSum(TreeNode root, int sum) {
        Set set = new HashSet();
        int count = 0;
        subSum(root, 0, sum, set, count);
        return count;
    }
    
    private void subSum(TreeNode root, int sum, int target, Set set, int count) {
        if (root == null) return;
        else{            
            Set temp = new HashSet();
            temp = set;
            sum += root.val;
            temp.add(sum + target);
            if (temp.contains(sum)) count++;
            if (root.left == null && root.right == null) return;
            else {
                subSum (root.left, sum, target, temp, count);
                subSum (root.right, sum, target, temp, count);
                return;
            }
        }
    }
}
*/