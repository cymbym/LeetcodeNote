/*
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].

1.我的解法：第一个循环在HashSet中存储所有词。          25ms。
            第二个循环，对每个单词，都进行逐位遍历，一旦其某几位不存在，直接退出该词，开始遍历下一个词。若全存在，则存储最长最靠前的词。
2.最优解：构建类字典树，包含一个字典树结点数组，一个String。
          首先对每个词都进行建树，以26->26->26->26->26在一个root中存储所有结果。并在这个循环里对root进行深遍，不断返回最大长度的那个结果，如app，返回app。
		                          root
		                        .children
		                            a -> p -> p
		                            a -> p -> p -> l -> e
		                            b -> a -> n -> a -> n -> a
		                        .end
                                  null null	app
                                  null null	null null apple
                                  null null	null null null banana										  
*/

class Solution {
    public String longestWord(String[] words) {
        String ans = "";
        HashSet<String> set = new HashSet<String>();
        for (String s: words) set.add(s);
        for (String s: words) {
            boolean contain = true;
            int i = 1;
            while(i < s.length()) {
                if (!set.contains(s.substring(0, i))) {
                    contain = false;
                    break;
                } else i ++;
            }
            if (contain) {
                if (s.length() > ans.length()) ans = s;
                else if (s.length() == ans.length() && ans.compareTo(s) > 0) ans = s;
            }
        }
        return ans;
    }
}


class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String end = "";
    }
    
    public void insert(TrieNode root, String word){
        TrieNode currNode = root;
        for(char c: word.toCharArray()){
            if(currNode.children[c-'a'] == null){
                currNode.children[c-'a'] = new TrieNode();                
            }
            currNode = currNode.children[c-'a'];  
        }
        currNode.end = word;
    }
    
    public String longestWord(String[] words) {
        
        TrieNode root = new TrieNode();
        for(String word: words){
            insert(root, word);
        } 
        return dfs(root);
    }
    public String dfs(TrieNode node){
        String res = node.end;
        for(TrieNode child : node.children){
            if(child != null && child.end.length() != 0){
                String nextWord = dfs(child);
                if(nextWord.length() > res.length())
                    res = nextWord;
            }
        }
        return res;
    }
}