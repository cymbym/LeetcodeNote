/*
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

1.在两层循环里判断质数个数，超时了ORZ。
2.质数不好找，但合数好找，因为它一定是某些数的倍数。找到n开方后的那个数i，遍历2到i之间的数的倍数，如：[4,6,8,…,n]; [9,12,15,…,n]; [16,20,…,n]; ……
3.遍历合数，有种更快捷的思路，即直接砍一半，不考虑偶数。找到n开方后的那个数i，遍历3到i之间的数的倍数，如：[9,12,15,…,n]; [25,30,35,…,n]; ……

*/

Ans1(Time Limit Exceeded):
class Solution {
    public int countPrimes(int n) {
		if(n <= 2){
			return 0;
		}else{
			int count = 0;
			for(int i = 2; i < n ; i ++){
				if(isPrime(i)) count ++;
			}
			return count;
		}
        
    }
	private boolean isPrime(int n){
		int count = 0;
		for(int i = 2; i < n; i ++){
			if(n % i != 0) count ++;
		}
		return count == n-2;
	}
}

Ans2:
class Solution {
    public int countPrimes(int n) {
		if(n <= 2){
			return 0;
		}else{
			boolean isPrime[] = new boolean[n];
			int count = n-2;
			for(int i = 2; i * i < n ; i ++){
				if(!isPrime[i]){
					for(int j = i * i; j < n ; j += i){
						if(!isPrime[j]){
							isPrime[j] = true;
							count--;
						}
					}
				}
			}
			return count;
		}
    }
}

Ans3:
class Solution {
    public int countPrimes(int n) {
		if(n <= 2){
			return 0;
		}else{
			boolean isPrime[] = new boolean[n];
			int count = n/2;
			for(int i = 3; i * i < n ; i += 2){
				if(!isPrime[i]){
					for(int j = i * i; j < n ; j += 2 * i){
						if(!isPrime[j]){
							isPrime[j] = true;
							count--;
						}
					}
				}
			}
			return count;
		}
    }
}