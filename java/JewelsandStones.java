/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.

1.直接用两次循环。
*/

class Solution {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        char[] j = J.toCharArray();
        char[] s = S.toCharArray();
        boolean[] map = new boolean[58];
        for (char c: j) map[c - 65] = true;
        for (char c: s) if (map[c - 65]) res ++;
        return res;
    }
}