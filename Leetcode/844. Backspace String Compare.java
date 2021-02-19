/* Problem Link: https://leetcode.com/problems/backspace-string-compare/ */

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<Character>();
        Stack<Character> t = new Stack<Character>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (s.empty() == false) s.pop();
                else {
                }
                ;
            } else s.push(S.charAt(i));
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (t.empty() == false) t.pop();
                else {
                }
                ;
            } else t.push(T.charAt(i));
        }
        try {
            while (s.empty() == false && s.empty() == false) {
                if (s.peek() != t.peek()) {
                    return false;
                }
                s.pop();
                t.pop();
            }
        } catch (Exception e) {

        }
        if (s.empty() == true && t.empty() == true) return true;
        if (s.empty() == true || t.empty() == true) return false;
        return true;
    }
}
