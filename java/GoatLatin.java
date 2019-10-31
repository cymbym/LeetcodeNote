/*
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin. 

 

Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 

Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.


1.我的解法：用String挨个处理。3ms。
2.最优解：用StringBuilder和String处理。1ms。
*/

class Solution {
    public String toGoatLatin(String S) {
        String[] aa = S.split(" ");
        String res = "";
        for (int i = 0 ; i <aa.length ; i++ ) {
            String head = aa[i].substring(0, 1);
            if (head.equals("a") || head.equals("e") || head.equals("i") || head.equals("o") || head.equals("u") || head.equals("A") || head.equals("E") || head.equals("I") || head.equals("O") || head.equals("U")) {
                String tmp = aa[i];
                tmp += "ma";
                int j = i;
                while (j >= 0) {
                    tmp += "a";
                    j --;
                }
                aa[i] = tmp;
            } else {
                String tmp = aa[i].substring(1);
                tmp += head +  "ma";
                int j = i;
                while (j >= 0) {
                    tmp += "a";
                    j --;
                }
                aa[i] = tmp;
            }
            if (i == 0) res = aa[i];
            else res += " " + aa[i];
        }
        return res;
    }
}

class Solution {
    boolean isVowel(char c) {
        return Character.toLowerCase(c) == 'a' || Character.toLowerCase(c) == 'e' || Character.toLowerCase(c) == 'i' || Character.toLowerCase(c) == 'o' || Character.toLowerCase(c) == 'u';
    }
    public String toGoatLatin(String s) {
        StringBuilder sb = new StringBuilder();
        char start = ' ';
        int idx = 0;
        s = s + " ";
        for (int i = 0; i < s.length(); ++i) {
            if (start == ' ' && s.charAt(i) != ' ') {
                start = s.charAt(i);
                ++idx;
                if (!isVowel(s.charAt(i)))
                    continue;
            } else if (s.charAt(i) == ' ') {
                if (!isVowel(start))
                    sb.append(start);
                sb.append("ma");
                for (int j = 0; j < idx; ++j)
                    sb.append('a');
                start = ' ';
            }
            sb.append(s.charAt(i));
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}