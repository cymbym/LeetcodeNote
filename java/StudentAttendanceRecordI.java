/*
You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False

1.最简单语句：if else和循环。
*/

class Solution {
    public boolean checkRecord(String s) {
        int cntA = 0;
        int cntL = 0;
        char[] c = s.toCharArray();
        for (char i : c) {
            if (i == 'A') {
                cntA ++;
                cntL = 0;
            }
            else if (i == 'L') cntL ++;
            else {
                cntL = 0;
                continue;
            }
            if (cntA > 1 || cntL > 2) return false;
        }
        return true;
    }
}