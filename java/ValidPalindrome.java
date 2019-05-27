/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

1.使用递归，想先判断首部和尾部，随后不断取中间的部分，继续调用isPalindrome。
2.但不知道是调用了太多系统函数，还是因为递归的原因，时间复杂度爆炸，以实际行动证明：少用递归！！！
3.最佳答案构造了一个方法，只映射出字母和数字，忽略其他字符，同时匹配大小写，如下：

class Solution {
    private static final char[]charMap = new char[256];
static{
    for(int i=0;i<10;i++){
        charMap[i+'0'] = (char)(1+i);  // numeric
    }
    for(int i=0;i<26;i++){
        charMap[i+'a'] = charMap[i+'A'] = (char)(11+i);  //alphabetic, ignore cases
    }
}
public boolean isPalindrome(String s) {
    char[]pChars = s.toCharArray();
    int start = 0,end=pChars.length-1;
    char cS,cE;
    while(start<end){
        cS = charMap[pChars[start]];
        cE = charMap[pChars[end]];
        if(cS!=0 && cE!=0){
            if(cS!=cE)return false;
            start++;
            end--;
        }else{
            if(cS==0)start++;
            if(cE==0)end--;
        }
    }
    return true;
}
}
*/

class Solution {
    class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
		int end = s.length()-1;
		if(end <= 0)   return true; 
        else
        {
            while((start < end) && !Character.isLetterOrDigit(s.charAt(start)))
            {
                start ++;
            }
            while((start < end) && !Character.isLetterOrDigit(s.charAt(end)))
            {
                end --;
            }
			if(start >= end){
				return true;
            }else if(s.substring(start, start+1).equalsIgnoreCase(s.substring(end, end+1)) || Character.isDigit(s.charAt(start)) && Character.isDigit(s.charAt(end)) && s.charAt(start)==s.charAt(end)){
                return isPalindrome(s.substring(start+1, end));
            }else{
                return false;
            }
        }
    }
}
}