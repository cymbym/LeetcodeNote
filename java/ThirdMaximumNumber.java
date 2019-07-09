/*
Given a non-empty array of integers, return the third maximum number in this array.
 If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

class Solution {
    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int flag = 0;
        for(int i : nums){
            if(first == i && i != Integer.MIN_VALUE) continue;
            else if(first == Integer.MIN_VALUE){
                first = i;
                flag ++;
            }
            else if(first < i){
				third = second;
				second = first;
                first = i;
				flag ++;
            }else{
                if(second == i && i != Integer.MIN_VALUE) continue;
                else if(second == Integer.MIN_VALUE){
                    second = i;
                    flag ++;
                } 
                else if(second < i){
					third = second;
                    second = i;
					flag ++;
                }else{
                    System.out.println(flag);
                    if(third == i && i != Integer.MIN_VALUE )continue;
                    else if(third == Integer.MIN_VALUE){
                        third = i;
                    } 
                    else if(third < i){
                        third = i;
                    }
                    flag ++;
                }
            }
        }
		return flag >= 3 ? third : first;
    }
}

[-2147483648,-2147483648,-2147483648,-2147483648,1,1,1]