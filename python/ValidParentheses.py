"""
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

1.����RomanToInt����ƥ���ϵ�����ǽ����ֵ�
2.���ڴ��ڶ�Ӧ��ϵ����������ֵ�˼�룬��������ջ(python��list����)����������������
	����������ջ��Ȼ�����Ұ����ȥ��ײ������ֱ��ջ�գ���Ϊ��ȷ��
"""
class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        dict = {"}": "{", "]": "[", ")": "("}
        stack=[None]
        for i in s:
            if i in dict:
                if dict[i] != stack.pop():
                    return False
            else:
                stack.append(i)
        return len(stack)==1