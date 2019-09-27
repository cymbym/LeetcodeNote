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

1.先在第一个循环里找到第一个1和最后一个1的位置。
    若全为0，如000，判断0的总数，即n <= (flowerbed.length + 1) / 2;即可。
	若存在1，则分别判断head之前、tail之后，0的个数。以及head和tail之间0的个数。
	

*/
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int head = 0;
        int tail = flowerbed.length - 1;
        boolean findHead = false;
        boolean findTail = false;
        while ((!findHead || !findTail) && tail - head >= 0) {                 //先找到第一个1和最后一个1的位置
            if (!findHead && flowerbed[head] != 1) head ++;
            else findHead = true;
            if (!findTail && flowerbed[tail] != 1) tail --;
            else findTail = true;
        }
        if (!findHead && !findTail) return n <= (flowerbed.length + 1) / 2;    //全为0，如000，判断0的总数(两两一组)
        else {                                                                 //不全为0，则分两步：
            if (n <= 0) return true;
            else n = n - head / 2 - (flowerbed.length - 1 - tail) / 2;         // 1)head之前、tail之后，0的个数(两两一组)
        }
        while (head < tail - 2) {                                              // 2)head和tail之间，0的个数(三个一组)
            if (n <= 0) return true;
            else {
                if (flowerbed[head] == 0 && flowerbed[head + 1] == 0 && flowerbed[head + 2] == 0) {
                    n --;
                    head += 2;
                }
                else head ++;
            }
        } return n <= 0;
    }
}