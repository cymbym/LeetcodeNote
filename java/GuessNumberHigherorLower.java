/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example :

Input: n = 10, pick = 6
Output: 6

1.首先得看懂题意：int guess(int num)是我们可以调用的函数，参数num是我们可以多次代入猜测的数，如果guess(num)返回0，所得num即为我们所要返回的guessNumber(n).
2.因此需要对1~n的数进行猜测，不采用1~n逐个尝试，而选择分而治之，取中点改区间，不断缩小范围。

*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int head = 0;
        while(head < n){
            if(guess(head) == 0){
                return head;
            }else if(guess(n) == 0){
                return n;
            }else{
                int  mid = head + (n - head) / 2;
                if(guess(mid) == 0){
                    return mid;
                }else if(guess(mid) == -1){
                    n = mid;
                }else if(guess(mid) == 1){
                    head = mid;
                }
            }		
        }
        return head;
    }
}