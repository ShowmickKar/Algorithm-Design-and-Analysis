/* Problem Link: https://leetcode.com/problems/backspace-string-compare/ */


/* Approach 1: Using Stack, Time Complexity: O(M+N), Space Complexity: O(M+N) */

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

/* Approach 1: Using Two Pointers, Time Complexity: O(M+N), Space Complexity: O(1) **Faster than 100% Java submissions** */

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int s = S.length() - 1, t = T.length() - 1, tb = 0, sb = 0;
        if (s < 0 && t < 0) {
            return true;
        }
        if (s < 0 || t < 0) {
            return false;
        }
        while (s >= 0 && t >= 0) {
            while (s >= 0 && (S.charAt(s) == '#' || sb < 0)) {
                if (S.charAt(s) == '#') {
                    sb--;
                } else {
                    sb++;
                }
                s--;
                if (s < 0)
                    break;
            }
            while (t >= 0 && (T.charAt(t) == '#' || tb < 0)) {
                if (T.charAt(t) == '#') {
                    tb--;
                } else {
                    tb++;
                }
                t--;
                if (t < 0)
                    break;
            }
            if (s >= 0 && t >= 0 && S.charAt(s) != T.charAt(t)) {
                return false;
            }
            if (s < 0 || t < 0)
                break;
            s--;
            t--;
        }
        if ((s < 0 && t >= 0 && T.charAt(t) != '#') || (t < 0 && s >= 0 && S.charAt(s) != '#'))
            return false;
        return true;
    }
}
