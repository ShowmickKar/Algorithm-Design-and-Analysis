# Problem Link: https://leetcode.com/problems/valid-parentheses/

class Solution:
    def isOpening(self, x):
        return x == '(' or x == '{' or x == '['
    
    def isEquivalent(self, opening, closing):
        return opening == '(' and closing == ')' or opening == '{' and closing == '}' or opening == '[' and closing == ']'
    
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if self.isOpening(c):
                stack.append(c)
            else:
                if not len(stack) or not self.isEquivalent(stack[-1], c):
                    return False
                stack.pop()
        return not len(stack)
