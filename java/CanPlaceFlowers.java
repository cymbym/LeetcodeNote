/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Note:
1.The length of both lists will be in the range of [1, 1000].
2.The length of strings in both lists will be in the range of [1, 30].
3.The index is starting from 0 to the list length minus 1.
4.No duplicates in both lists.

1.我的解法：在同一个循环里，用一个HashMap存储出现过的字符及下标，并将最小下标和min与出现了两次的数的下标之和temp进行比较。 11ms。
2.最优解：仅多了个if(i > min) break;提前结束遍历。5ms。

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