/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

1.ʹ�õݹ飬�����ж��ײ���β������󲻶�ȡ�м�Ĳ��֣���������isPalindrome��
2.����֪���ǵ�����̫��ϵͳ������������Ϊ�ݹ��ԭ��ʱ�临�Ӷȱ�ը����ʵ���ж�֤�������õݹ飡����
3.��Ѵ𰸹�����һ��������ֻӳ�����ĸ�����֣����������ַ���ͬʱƥ���Сд�����£�

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