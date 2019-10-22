/*
Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.

(Recall that the number of set bits an integer has is the number of 1s present when written in binary.
 For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

Example 1:

Input: L = 6, R = 10
Output: 4
Explanation:
6 -> 110 (2 set bits, 2 is prime)
7 -> 111 (3 set bits, 3 is prime)
9 -> 1001 (2 set bits , 2 is prime)
10->1010 (2 set bits , 2 is prime)
Example 2:

Input: L = 10, R = 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
Note:

L, R will be integers L <= R in the range [1, 10^6].
R - L will be at most 10000.

1.我的解法：用HashMap存储每一个数对应的1的个数（这个其实可以直接用Integer.bitCount(L)）作为key，以及该个数出现的次数作为value。
            随后判断各个key是否为质数。43ms。
2.改进版：不用HashMap，而是每次获得对应的1的个数后，直接判断是否为质数。15ms。
3.较优解：提供了一个L &= (L - 1);判断L中1的个数。随后直接判断各个key是否为质数。6ms。

            
*/

class Solution {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (L <= R) {
            int temp = countSetBits(L);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            L ++;
        }
        for (int key : map.keySet()) {
            if (isPrime(key)) res += map.get(key);
        }
        return res;
    }
    public int countSetBits(int L) {
        int cnt = 0;
        while (L != 0) {
            cnt += L % 2;
            L /= 2;
        }
        return cnt;
    }
    public boolean isPrime(int k) {
        if (k <= 1) return false;
        else {
            int i = 2;
            while (i * i <= k) {
                if (k % i == 0) return false; 
                i ++;
            }
            return true;
        }
    }
}

class Solution {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (L <= R) {
            int temp = countSetBits(L);
            if (isPrime(temp)) res ++;
            L ++;
        }
        return res;
    }
    public int countSetBits(int L) {
        int cnt = 0;
        while (L != 0) {
            cnt += L % 2;
            L /= 2;
        }
        return cnt;
    }
    public boolean isPrime(int k) {
        if (k <= 1) return false;
        else {
            int i = 2;
            while (i * i <= k) {
                if (k % i == 0) return false; 
                i ++;
            }
            return true;
        }
    }
}

class Solution {
    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for(int i = L; i <= R; i++) {
            int countOnes = 0;
            int temp = i;
            while(temp > 0) {
                countOnes++;
                temp &= (temp - 1);
            }   
            if (isPrime(countOnes))  result++;
        }
        return result;
    }
    
    private boolean isPrime(int n) {
        // System.out.println(n);
        if (n <= 1) return false;
        for(int i = 2 ; i <= (int)Math.sqrt(n) ;i++) {
            if (n % i == 0) {
                return false;
            }
        } 
        return true;
    }
}