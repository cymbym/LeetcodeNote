/*
Given an integer array with even length, where different numbers in this array represent different kinds of candies.
 Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister.
 Return the maximum number of kinds of candies the sister could gain.
Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
The sister has three different kinds of candies. 
Example 2:
Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
The sister has two different kinds of candies, the brother has only one kind of candies. 
Note:

The length of the given array is in range [2, 10,000], and will be even.
The number in given array is in range [-100,000, 100,000].

1.直接用Arrays.sort(candies)排序，随后在一个循环里找新的数。50ms。
2.在一个循环里用HashMap存储新的数。37ms。
3.在一个循环里用boolean[]存储新的数。6ms。

*/



class Solution {
    public int distributeCandies(int[] candies) {
        if (candies.length == 0) return 0;
        else {
            Arrays.sort(candies);
            int res = 1;
            for (int i = 1; i < candies.length; i ++) {
                if (res == candies.length / 2) return res;
                else if (candies[i] != candies[i - 1]) res ++;
            }
            return res;
        }
    }
}

class Solution {
    public int distributeCandies(int[] candies) {
        if (candies.length == 0) return 0;
        else {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int res = 0;
            for (int i = 0; i < candies.length; i ++) {
                if (res == candies.length / 2) return res;
                else {
                    int temp = map.getOrDefault(candies[i],0);
                    if (temp == 0) {
                        res ++;
                        map.put(candies[i], temp + 1);
                    }   
                }
            }
            return res;
        }
    }
}

class Solution {
    public int distributeCandies(int[] candies) {
        if (candies.length == 0) return 0;
        else {
            boolean[] map = new boolean[200001];
            int res = 0;
            for (int i = 0; i < candies.length; i ++) {
                if (res == candies.length / 2) return res;
                else {
                    if (!map[candies[i] + 100000]) {
                        res ++;
                        map[candies[i] + 100000] = true;
                    }   
                }
            }
            return res;
        }
    }
}