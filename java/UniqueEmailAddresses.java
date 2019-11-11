/*
Every email consists of a local name and a domain name, separated by the @ sign.

For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

Besides lowercase letters, these emails may contain '.'s or '+'s.

If you add periods ('.') between some characters in the local name part of an email address,
 mail sent there will be forwarded to the same address without dots in the local name.
 For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 (Note that this rule does not apply for domain names.)

If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
 This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
 (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

Given a list of emails, we send one email to each address in the list.
  How many different addresses actually receive mails? 

 

Example 1:

Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 

Note:

1 <= emails[i].length <= 100
1 <= emails.length <= 100
Each emails[i] contains exactly one '@' character.
All local and domain names are non-empty.
Local names do not start with a '+' character.

1.我的解法：按位转存入StringBuilder中。随后用toString()存到HashSet中。9ms。
2.最优解：按位转存入char[]中，挨位记录更新了的下标lastIndex。随后用new String(arr, 0, lastIndex + 1)存到HashSet中。3ms。
*/

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();
        for (String s: emails) {
            char[] c = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            int i;
            for (i = 0; i < c.length; i ++) {
                if (c[i] == '@') break;
                else if (c[i] == '+') {
                    while (c[i] != '@') i ++;
                    break;
                }
                else if (c[i] != '.') sb.append(c[i]);
            }
            for (i = i; i < c.length; i ++) sb.append(c[i]);
            set.add(sb.toString());
        }
        return set.size(); 
    }
}

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < emails.length; i++){
            set.add(getFilteredEmailId(emails[i]));
        }
        return set.size();
    }
    
    String getFilteredEmailId(String input) {
		char[] arr = input.toCharArray();
		int shift = 0;
		boolean plusDetected = false;
		boolean atTheRateNotDetected = true;
		int lastIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '@') {
				atTheRateNotDetected = false;
			}
			if (arr[i] == '+') {
				plusDetected = true;
			}
			if ((arr[i] == '.' || plusDetected) && atTheRateNotDetected) {
				shift++;
				continue;
			}
			lastIndex = i - shift;
			arr[lastIndex] = arr[i];
		}
		return new String(arr, 0, lastIndex + 1);
	}
}