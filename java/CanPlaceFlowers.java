/*
Suppose you have a long flowerbed in which some of the plots are planted and some are not.
 However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
 and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
Note:
The input array won't violate no-adjacent-flowers rule.
The input array size is in the range of [1, 20000].
n is a non-negative integer which won't exceed the input array size.



*/
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int len = Math.max(list1.length, list2.length);
        for (int i = 0; i < len; i ++) {
            if (i < list1.length) {
                if (map.containsKey(list1[i])) {
                    int temp = i + map.get(list1[i]);
                    if (min >= temp) {
                        res.add(list1[i]);
                        min = temp;
                    }
                } else map.put(list1[i], i);
            }
            if (i < list2.length) {
                if (map.containsKey(list2[i])) {
                    int temp = i + map.get(list2[i]);
                    if (min >= temp) {
                        res.add(list2[i]);
                        min = temp;
                    }
                } else map.put(list2[i], i);
            }
			if(i > min) break;     //此处大大缩短时间
        }
        return res.toArray(new String[res.size()]);
    }
}