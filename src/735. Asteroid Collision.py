# Problem Link: https://leetcode.com/problems/asteroid-collision/

class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        ans = []
        stack = []
        for c in asteroids:
            if c > 0:
                stack.append(c)
            else:
                while len(stack) and stack[-1] < abs(c):
                    stack.pop()
                if not(len(stack)):
                    ans.append(c)
                    continue
                if abs(c) == stack[-1]:
                    stack.pop()
                
        ans.extend(stack)
        return ans
