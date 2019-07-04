/*
You are a product manager and currently leading a team to develop a new product.
 Unfortunately, the latest version of your product fails the quality check.
 Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad.
 Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 

1.采用分而治之（Divide and conquer）的思想，不断取中点，缩小区间。
2.由于(head + n)在二者都很大时可能会溢出，我选择将(head + n)变成long型，但需要每次调用isBadVersion()时强制转换为int。
3.答案选择int mid = left + (right - left) / 2; 就不用担心溢出问题了。

*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long head = 0;
        long mid = 0;
        while(head < n - 1){
            mid = (head + n) / 2;
            if(isBadVersion((int)mid)){
                n = (int)mid;
            }else{
                head = mid;
            }
        }
        return isBadVersion((int)mid) ? (int)mid : (int)mid + 1;
    }
}

