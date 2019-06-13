/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"

1.��ϸ������Ŀ����ʵ����һ��ʮ����ת26���Ƶ����⣬��շת�������������ȡ������ֱ���̱�Ϊ0������
2.��ע����26��52���ֱ��ӦZ��AZ����������Ϊ0ʱ����Ҫ����һ�������������������Ϊ26����һ�����Լ�1����26 = 26*1+0 = 26*0+26 = Z��52 = 26*2+0 = 26*1+26 = AZ
3.����һ���ݹ�ⷨ��һ�н����ɥ�Ĳ��񰡣� return n == 0 ? "" : convertToTitle(n / 26) + (char)(--n % 26 + 'A');

*/

class Solution {
    public String convertToTitle(int n) {
        String res = "";
		while(n != 0){
			int remainder = n % 26;
			if(remainder == 0){
				res = convertToLetter(remainder + 26) + res;
				n = n / 26 - 1;
			}else{
				res = convertToLetter(remainder) + res;
				n /= 26;
			}
		}
		return res;
    }
	public char convertToLetter(int n){
		return (char)(n + 64);
	}
}