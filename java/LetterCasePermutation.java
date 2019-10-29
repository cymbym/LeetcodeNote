/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.

1.我的解法：挨个遍历S：如果是字母，则在List<String> res中更新两次；如果不是，则更新一次。
                       如果是第一次更新，直接加入res；如果不是，则先增补，后替换更新。   3ms。
2.最优解：挨个遍历S：递归进行更新和加入res。  1ms。
*/

class Solution {
    List<String> res;
    public List<String> letterCasePermutation(String S) {
        res = new ArrayList<String>();
        for (char c: S.toCharArray()) updateString(c);
        return res;
    }
    public void updateString(char c) {
        int len = res.size();
        if (len == 0) {
            if (c >= 'A' && c <= 'Z') res.add(Character.toLowerCase(c) + "");
            else if (c >= 'a' && c <= 'z') res.add(Character.toUpperCase(c) + "");
            res.add(c + "");
        }
        else {
            for (int i = 0; i < len; i ++) {                       
                if (c >= 'A' && c <= 'Z') res.add(res.get(i) + Character.toLowerCase(c));
                else if (c >= 'a' && c <= 'z') res.add(res.get(i) + Character.toUpperCase(c));
                res.set(i, res.get(i) + c);
            }
        }
    }
}

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<String>();
        helper(S.toCharArray(), 0, res);
        return res;
    }
    public void helper(char[] list, int i, List<String> res) {
        if (i == list.length) {
            res.add(String.valueOf(list));
            return;
        }
        char c = list[i];
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            list[i] = Character.toLowerCase(c);
            helper(list, i + 1, res);
            list[i] = Character.toUpperCase(c);
            helper(list, i + 1, res);
        }
        else helper(list, i + 1, res);
    }
}
    List<String> res;
    public List<String> letterCasePermutation(String S) {
        res = new ArrayList<String>();
        for (char c: S.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) updateString(c, true);
            else updateString(c, false);
        }
        return res;
    }
    public void updateString(char c, boolean isLetter) {
        if (res.size() == 0) {
            if (isLetter) {
                if (c <= 'Z') res.add(c + 32);
                else res.add(c - 32);
            } else res.add(c);
        }
        else {
            for (int i = 0; i < res.size(); i ++) {
                if (isLetter) {
                    res.set(i, res.get(i) + c);
                    if (c <= 'Z') res.add(res.get(i) + (c + 32));
                    else res.add(res.get(i) + (c - 32));
                } else res.set(i, res.get(i) + c);
            }
        }
    }
}