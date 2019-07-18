/*
Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line,
 find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:

Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters' warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.
 

Example 1:

Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 

Example 2:

Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.

1.我的思路：将第一个数组视为钥匙，第二个数组视为门，钥匙去匹配最接近的门。
  a.当相等时，钥匙递增；b.当门到尽头或者差值变大时，钥匙递增，存储差值；当差值依然在减小，门递增。
2.最优解：所匹配的数满足，钥匙*2 小于 门及下一个门之和，否则门递增。相比我的解法，少了计算绝对值和几处判断语句
  
*/

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int key = 0;
        int door = 0;
        int res = 0;
        while (key < houses.length && door < heaters.length) {
            if (houses[key] == heaters[door]) key ++;
            else {
                int temp = Math.abs(houses[key] - heaters[door]);
                if (door + 1 == heaters.length || temp < Math.abs(houses[key] - heaters[door + 1])){
                    key ++;
                    res = (res >= temp) ? res : temp;
                } else door ++;
            }
            
        }
        return res;
    }
}

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, res = 0;
        for(int h: houses) {
            while(i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= h * 2) i++;
            res = Math.max(res, Math.abs(heaters[i] - h));
        }
        return res;
    }
}