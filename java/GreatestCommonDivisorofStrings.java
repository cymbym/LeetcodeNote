/*
For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)

Return the largest string X such that X divides str1 and X divides str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
      
	  
1.我的解法：将字符串根据长短分为三段，短的字符串，长的字符串前半段，长的字符串后半段。 2ms。
            选择三段中最短的那段，去与其他两段进行逐位比较，不等则返回""。
            获取三段的长度的最大公约数，作为最终长度，返回该长度对应的字符串。
2.最优解：先比较str1+str2，和str2+str1，两段比较是否相等。                             0ms。
          随后获取两段长度的最大公约数，作为最终长度，返回该长度对应的字符串。
*/

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int dif = str1.length() - str2.length();
        if (dif == 0) {
            if (str1.equals(str2)) return str2;
            else return "";
        }
        char[] c1 = dif >= 0 ? str1.toCharArray(): str2.toCharArray();
        char[] c2 = dif >= 0 ? str2.toCharArray(): str1.toCharArray();
        dif = Math.abs(dif);
        if (c2.length >= dif) {
            int ix1 = 0;
            int ix = c2.length;
            while (ix1 < c1.length) {
                if (ix == c1.length) ix -= dif;
                if (ix1 < c2.length) {
                    if (c1[ix1] != c1[ix] && c2[ix1] != c1[ix]) return "";
                } else {
                    if (c1[ix1] != c1[ix]) return "";
                }
                ix1 ++;
                ix ++;
            }
            int len = maxGcd(c1.length, c2.length, dif);
            return new String(c1, c2.length, len);
        } else {
            int ix1 = 0;
            int ix = 0;
            while (ix1 < c1.length) {
                if (ix == c2.length) ix -= c2.length;
                if (ix1 < c2.length) {
                    if (c1[ix1] != c2[ix] && c1[c2.length + ix1] != c2[ix]) return "";
                } else {
                    if (c1[ix1] != c2[ix]) return "";
                }
                ix1 ++;
                ix ++;
            }
            int len = maxGcd(c1.length, c2.length, dif);
            return new String(c2, 0, len);
        }
    }
    public static int maxGcd(int a, int b, int c) {
        List<Integer> l = new ArrayList<Integer>();
        int max_Gcd = 1;
        for (int i = 1; i < Math.max(Math.max(a, b), c); i++) {
            if (a % i == 0 && b % i == 0 && c % i == 0) {
                l.add(i);
            }
        }
        for (Integer integer : l) {
            max_Gcd = 1;
            max_Gcd *= integer;
        }
        return max_Gcd;
    }
}

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))
            return "";
        
        int len1 = str1.length();
        int len2 = str2.length();
        
        int gcd = GCD(len1,len2);
        
        return str1.substring(0,gcd);
    }
    
    public int GCD(int a,int b){
        if(b == 0)
            return a;
        
        return a % b == 0 ? b : GCD(b,a % b);
    }
}