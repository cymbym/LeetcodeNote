/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]


*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> large = new ArrayList<List<Integer>>();
		if(numRows == 0){
			return large;
		}else{
			for(int i = 0; i < numRows; i ++){
                List<Integer> small = new ArrayList<Integer>();
                small.add(1);
                for(int j = 1; j < i; j++){
                    small.add(large.get(i-1).get(j-1) + large.get(i-1).get(j));
                }
                if(i != 0) small.add(1);
                large.add(small);
			}
			return large;
		}
    }
}