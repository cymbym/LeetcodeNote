/*
For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
  For example, if X = 1231, then the array form is [1,2,3,1].

Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.

 

Example 1:

Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
Example 2:

Input: A = [2,7,4], K = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:

Input: A = [2,1,5], K = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
Example 4:

Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
Output: [1,0,0,0,0,0,0,0,0,0,0]
Explanation: 9999999999 + 1 = 10000000000
 

Note：

1 <= A.length <= 10000
0 <= A[i] <= 9
0 <= K <= 10000
If A.length > 1, then A[0] != 0

1.我的解法：从A和K的个位往高位，逐位累加给tmp。需注意考虑A和K谁的位数高的问题。     43ms。
            新增的数，利用res.add(0, tmp);加到res头部。
            最后需要注意标志位flag是否需要进1。
2.最优解：  从A的个位往高位，逐位累加K给tmp，A[i]更新为tmp%10，同时K更新为tmp/10。  2ms。
            当A[i]结束时，若K还没结束，挨个赋值给res。
            最后，将A[i]的值正序加到res尾部。 【这步很重要，节约了时间复杂度】

ArrayList<Integer>()中add(int index, object o)的时间复杂度是o(n)，add(object o)的时间复杂度是o(1)，所以尽量从尾部添加元素。
*/

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>();
        int flag = 0;
        int tmp = 0;
        int i = A.length - 1;
        while (K != 0 || i >= 0) {
            if (i >= 0) tmp = A[i --] + K % 10 + flag;
            else tmp = K % 10 + flag;
            flag = tmp / 10;
            tmp %= 10;
            res.add(0, tmp);
            K /= 10;
        }
        if (flag == 1) res.add(0, flag);
        return res;
    }
}

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        for(int i = A.length-1;i>=0 && K!=0;i--){
            int temp = A[i] + K;
            A[i] = temp%10;
            K = temp/10;
        }
        
        List<Integer> B = new ArrayList<>();
        while(K!=0){
            B.add(0,K%10);
            K=K/10;
        }
        
        for(int i:A){
            B.add(i);
        }
        
        return B;
    }
}