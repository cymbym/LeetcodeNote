/*
Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.

 

Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]
 

Note:

1 <= arr.length <= 10000
0 <= arr[i] <= 9

1.双指针遍历，一个在原数组，一个在新数组，最后则倒序插入。
2.第一次遍历完需注意最后一位补齐后是否超出，若超出，则直接把最后一位置为0，从倒数第二位倒序插入；
                                            若不超出，直接从倒数第一位倒序插入。
*/

class Solution {
    public void duplicateZeros(int[] arr) {
        int head = 0;
        int tail = 0;
        while (tail < arr.length) {
            if (arr[head] == 0) tail ++;
            head ++;
            tail ++;
        }
        if (tail > arr.length) {
            tail = arr.length - 1;
            arr[tail] = 0;
            head --;
        }
        head --;
        tail --;
        while (tail >= 0) {
            if (arr[head] == 0) arr[tail --] = 0;
            arr[tail --] = arr[head --];
        }
    }
}