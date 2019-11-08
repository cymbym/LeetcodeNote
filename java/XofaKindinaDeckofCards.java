/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000

1.我的方法：先用HashMap<Integer, Integer> map存储每个数，及对应出现的次数。
            用HashSet<Integer> set存储所有的次数。其中最小的次数记为min。
            找到set中的数的公约数。如果只有同一个次数，直接返回true；
                                   否则从min,2,3,4,……,min/2，开始，挨个确定所有数的公约数。 8ms。
2.神仙解法：用数组存储每个数，及对应出现的次数。随后用一个函数gcd寻找两个数的公约数。       1ms。
*/



class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
		
		for (int i: deck) map.put(i, map.getOrDefault(i, 0) + 1);
		
		int min = Integer.MAX_VALUE;
		for (int key: map.keySet()) {
            int tmp = map.get(key);
			if (tmp < 2) return false;
			else set.add(tmp);
			if (tmp < min) min = tmp;
		}
		
		int maxTmp = 2;
        if (set.size() == 1) return true;
        else {
            int cnt = 0;
            for (int i: set) {
                if (i % min != 0) break;
                else cnt ++;
            }
            if (cnt == set.size()) return true;
            while (maxTmp <= min / 2) {
                cnt = 0;
                for (int i: set) {
                    if (i % maxTmp != 0) {
                        maxTmp ++;
                        break;
                    }
                    else cnt ++;
                }
                if (cnt == set.size()) return true;
            }
            return false; 
        }
    }
}

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[1000];
        for (int i=0; i<deck.length; i++)
            count[deck[i]]++;
        int group = -1;
        for (int i=0; i<1000; i++){
            if (count[i]!=0){
                if (group == -1)
                    group = count[i];
                else
                    group = gcd(group,count[i]);
            }
        }
        return group >= 2;
    }
    public int gcd(int x, int y){
        return x==0 ? y : gcd(y%x,x);
    }
}