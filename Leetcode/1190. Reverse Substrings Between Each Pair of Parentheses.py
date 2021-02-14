# Problem Link: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

class Solution:
    def reverseParentheses(self, s: str) -> str:
        stack = []
        for c in s:
            if c == ')':
                ans = ""
                while stack[-1] != '(':
                    ans += stack.pop()
                stack.pop()
                for i in ans:
                    stack.append(i)
            else:
                stack.append(c)
                
        return "".join(stack)
