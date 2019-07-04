/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.


1.原本以为只有0~9，便想用数组来处理，不想用set，但后来发现数据可以是任意大的。还是得用set方便。
2.最优解其实依然是用数组，只不过先遍历出数组的上下界。

*/



class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set_1 = new HashSet<Integer>();
        HashSet<Integer> set_2 = new HashSet<Integer>();
        for(int i : nums1){
            set_1.add(i);
        }
        for(int i : nums2){
            if(set_1.contains(i)) set_2.add(i);
        }
        int[] res = new int[set_2.size()];
		int count = 0;
        for(int i : set_2){
            res[count ++] = i;
        }
        return res;
    }
}


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num: nums1){
            if(num  > max){
                max = num;
            }
            
            if(num < min){
                min = num;
            }
        }        
        boolean [] check = new boolean[max -min +1];   //注意这个数组的声明  
        for(int num: nums1){
            check[num - min] = true;   //注意这个数组的下标
        }        
        int size = 0;
        int [] res = new int[max - min + 1];   //注意这个数组的声明
        
        for(int num: nums2)
        {
            if(num>=min && num<= max && check[num -min])
            {
                res[size++] = num;
                check[num-min] = false;
            }
        }        
        int [] result = new int[size];   //注意这个数组的声明
        
        for(int i = 0; i < size; i++)
        {
            result[i] = res[i];
        }
        
        return result;
    
    }
}

/* Wrong Answer:

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] map_1 = new boolean[10];
        boolean[] map_2 = new boolean[10];
        for(int i : nums1){
            map_1[i] = true;
        }
        int len = 0;
        for(int i : nums2){
            if(map_1[i] && !map_2[i]){
                map_2[i]=true;
                len ++;
            } 
        }
        int[] res = new int[len];
        for(int i = 0; i < 100; i++){
            if(map_2[i]){
                len--;
                res[len] = i;
            }
        }
        return res;
    }
} */