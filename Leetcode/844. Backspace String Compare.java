/* Problem Link: https://leetcode.com/problems/backspace-string-compare/ */

class Solution {
    public boolean backspaceCompare(String S, String T) {
class Solution {
    public boolean areSame(Stack<Character> s, Stack<Character> t) {
        return s.equals(t);
    }

    public Stack<Character> buildString(String S) {
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (s.empty() == false)
                    s.pop();
            } else {
                s.push(S.charAt(i));
            }
        }
        return s;
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = buildString(S);
        Stack<Character> t = buildString(T);
        return areSame(s, t);
    }
}
