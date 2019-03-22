/*
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

1.类似RomanToInt存在匹配关系，考虑建立Hash表
2.由于存在对应关系，类比消消乐的思想，考虑利用栈，后入先消，即：
	让左半符号入栈，然后让右半符号去碰撞消除，直至栈空，即为正确。
*/

class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 == 1){
            return false;
        }else{
            HashMap< String, String> map = new HashMap< String, String>(){
                {put( "}", "{");
                put("]", "[");
                put(")", "(");}
            };
            Stack<String> stack = new Stack<String>();
            for(int i = 0; i < s.length(); i ++){
                String temp = s.substring(i, i+1);
                if(map.containsKey(temp)){
                    if(stack.isEmpty()){
                        return false;
                    }else{
                        if(stack.pop().equals(map.get(temp)) == false){
                            return false;
                        }   
                    }
                }else{
                    stack.push(temp);
                }
            }
            return stack.isEmpty();
        }
    }
}