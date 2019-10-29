/*
International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
 as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
 For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-").
 We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
Note:

The length of words will be at most 100.
Each words[i] will have length in range [1, 12].
words[i] will only consist of lowercase letters.

1.将每个字母直接转存为对应的StringBuilder();，不断append，最后用HashSet存储起来。
    注意在HashSet中，即使元素完全相同，StringBuilder也是不同的，所以需要将StringBuilder再转化为String。
	
*/

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> map = new HashSet<String>();
        for (String s: words) {
            StringBuilder sb = new StringBuilder();
            for (char c: s.toCharArray()) {
                sb.append(morse[c - 97]);
            }
            map.add(sb.toString());
        }
        return map.size();
    }
}