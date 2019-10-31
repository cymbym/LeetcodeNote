/*
In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.

 

Example 1:

Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
Example 2:

Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.
Example 3:

Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
 

Note:  1 <= S.length <= 1000

1.在一个循环里不断判断即可。需注意List<List<Integer>> res = new ArrayList<List<Integer>>();的初始化方法。
*/

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        char[] c = S.toCharArray();
        int head = 0;
        int cnt = 1;
        for (int i = 1; i < c.length; i ++) {
            if (c[i] == c[i - 1]) cnt ++;
            else {
                if (cnt > 2) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(head);
                    tmp.add(i - 1);
                    res.add(tmp);
                }
                head = i;
                cnt = 1;
            }
        }
        if (cnt > 2) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(head);
            tmp.add(c.length - 1);
            res.add(tmp);
        }
        return res;
    }
}