# Problem Link: https://leetcode.com/problems/daily-temperatures/

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        ans = [0] * len(T)
        stack = []
        for i in range(len(T) - 1, -1, -1):
            while True:
                if not stack:
                    ans[i] = 0
                    stack.append((T[i], i))
                    break
                if stack[-1][0] <= T[i]:
                    stack.pop()
                    continue
                else:
                    ans[i] = stack[-1][1] - i
                    stack.append((T[i], i))
                    break
            
        return ans
