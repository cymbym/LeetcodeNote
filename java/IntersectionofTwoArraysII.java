/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?


1.我的解法：使用两个HashMap。
2.次优解：使用一个HashMap和一个ArrayList，我是想这么用的，可是我用的是HashMap和一个list，发现list无法用add()，且必须声明size。ArrayList很好地解决了这个问题。
3.最优解：先排序后用双指针。
*/



class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map_1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map_2 = new HashMap<Integer, Integer>();
        for(int i : nums1){
	        map_1.put(i, map_1.containsKey(i) ? map_1.get(i) + 1 : 1);
        }
        int count = 0;
        for(int i : nums2){
            if(map_1.containsKey(i)){
                if(map_2.containsKey(i)){
                    if(map_1.get(i) > map_2.get(i)){
                        map_2.put(i, map_2.get(i) + 1);
                        count ++;
                    }
                }else{
                    map_2.put(i, 1);
                    count ++;
                }
            }
        }
        int[] res = new int[count];
        for(int key : map_2.keySet()){
            for(int i = 0; i < map_2.get(key); i ++){
                res[count-1] = key;
                count --;
            }
        }
        return res;
    }
}


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }   
        for(int num:nums2){
            if(map.containsKey(num)){
                if(map.get(num) >0)
                   result.add(num);
                map.put(num,map.get(num)-1);
            }
        }  
        int[] ans = new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int[] res = new int[nums1.length];
        int p = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res[p++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return Arrays.copyOf(res, p);
    }
}
